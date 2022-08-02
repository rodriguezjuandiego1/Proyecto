package persistencia;

import excepciones.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import logica.Factura;
import logica.Facturas;
import logica.Tarifa;
import logica.Afiliado;
import logica.Afiliados;

public class PersistenciaFacturas {

    private final String CONSULTA_MENSUAL = "select * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private final String CONSULTA_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? ;";
    private final String CONSULTA_ATRASADOS = "SELECT * FROM adn.facturas WHERE fecha_pago is null group by afiliadoced having count(*)>2;";
    private final String CONSULTA_IMPAGAS_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? and fecha_pago is null;";
    private final String DELETE_MENSUAL = "delete * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private final String DELETE_AFILIADO = "delete * from adn.facturas where afiliadoced=? and concepto='cuota' and month(fecha_emision)=? and year(fecha_emision)=?;";
    private final String INSERTAR_FACTURA = "INSERT INTO adn.facturas (`afiliadoced`,`fecha_emision`, `concepto`, `importe`) VALUES (?, ?, ?, ?)";
    private final String PAGAR_FACTURA = "UPDATE adn.facturas SET `fecha_pago` = ? WHERE idfactura=?;";

    public void facturacionMensual(int mes, int anio) throws ExcepcionConectar, ExcepcionInsertarFactura, ExcepcionCerrarConexion, ExcepcionListarAfiliados, ParseException {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        Afiliados afiliadosActivos = afiliados.listarAfiliadosActivos();
        String fechaFacturacion = anio + "-" + mes + "-01";
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaFactura = formateador.parse(fechaFacturacion);
        PersistenciaTarifas persistenciaTarifas = new PersistenciaTarifas();
        Tarifa tarifa = persistenciaTarifas.getUltimaTarifa();
        for (int i = 0; i < afiliadosActivos.largo(); i++) {
            try {
                Afiliado afiliado = afiliadosActivos.getAfiliado(i);
                PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR_FACTURA);
                consultaPreparada.setString(1, afiliado.getCedula());
                consultaPreparada.setDate(2, new java.sql.Date(fechaFactura.getTime()));
                consultaPreparada.setString(3, "CUOTA");
                consultaPreparada.setDouble(4, tarifa.getCuota());
                consultaPreparada.executeUpdate();
            } catch (SQLException ex) {
                throw new ExcepcionInsertarFactura("Error al insertar la factura");
            } finally {
                conectar.cerrarConexion();
            }
        }
    }

    public void procesarBajas() throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionInactivarAfiliado {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();

        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ATRASADOS);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("afiliadoced"));
                PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
                afiliados.inactivarAfiliado(afiliado);

            }

        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("No se pudo modificar estado del afiliados");
        } finally {
            conectar.cerrarConexion();
        }
    }

    public Facturas listarFacturasAfiliado(Afiliado afiliado) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionListarFacturas {
        ArrayList<Factura> listafacturas = new ArrayList<>();
        Facturas facturas = new Facturas();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();

        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(CONSULTA_AFILIADO);
            consultaPreparada.setString(1, afiliado.getCedula());
            ResultSet resultado = consultaPreparada.executeQuery();
            while (resultado.next()) {
                Factura factura = new Factura();
                factura.setCedulaAfiliado(resultado.getString("afiliadoced"));
                factura.setFechaEmision(resultado.getDate("fecha_emision"));
                factura.setConcepto(resultado.getString("concepto"));
                factura.setFechaPago(resultado.getDate("fecha_pago"));
                factura.setIdentificador(resultado.getInt("idfactura"));
                listafacturas.add(factura);
            }
            facturas.setListaFacturas(listafacturas);
        } catch (SQLException ex) {
            throw new ExcepcionListarFacturas("No se pudo listar facturas");
        } finally {
            conectar.cerrarConexion();
        }
        return facturas;
    }

    public Facturas listarImpagasAfiliado(Afiliado afiliado) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionListarFacturas {
        ArrayList<Factura> listafacturas = new ArrayList<>();
        Facturas facturas = new Facturas();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();

        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(CONSULTA_IMPAGAS_AFILIADO);
            consultaPreparada.setString(1, afiliado.getCedula());
            ResultSet resultado = consultaPreparada.executeQuery();
            while (resultado.next()) {
                Factura factura = new Factura();
                factura.setCedulaAfiliado(resultado.getString("afiliadoced"));
                factura.setFechaEmision(resultado.getDate("fecha_emision"));
                factura.setConcepto(resultado.getString("concepto"));
                factura.setFechaPago(resultado.getDate("fecha_pago"));
                factura.setIdentificador(resultado.getInt("idfactura"));
                listafacturas.add(factura);
            }
            facturas.setListaFacturas(listafacturas);
        } catch (SQLException ex) {
            throw new ExcepcionListarFacturas("No se pudo listar facturas");
        } finally {
            conectar.cerrarConexion();
        }
        return facturas;
    }

}
