package persistencia;

import excepciones.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import logica.Factura;
import logica.Facturas;
import logica.Tarifa;
import logica.Afiliado;
import logica.Afiliados;

        



public class PersistenciaFacturas {

    private static final String CONSULTA_MENSUAL = "select * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private static final String CONSULTA_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? ;";
    private static final String CONSULTA_ATRASADOS_A_INACTIVAR = "SELECT * FROM adn.facturas WHERE fecha_pago is null group by afiliadoced having count(*)>2;";
    private static final String CONSULTA_ATRASADOS_A_NOTIFICAR = "SELECT * FROM adn.facturas WHERE fecha_pago is null group by afiliadoced having count(*)>1;";
    private static final String CONSULTA_IMPAGAS_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? and fecha_pago is null;";
    private static final String DELETE_MENSUAL = "delete * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private static final String DELETE_AFILIADO = "delete * from adn.facturas where afiliadoced=? and concepto='cuota' and month(fecha_emision)=? and year(fecha_emision)=?;";
    private static final String INSERTAR_FACTURA = "INSERT INTO adn.facturas (`afiliadoced`,`fecha_emision`, `concepto`, `importe`) VALUES (?, ?, ?, ?)";
    private static final String PAGAR_FACTURA = "UPDATE adn.facturas SET `fecha_pago` = ? WHERE idfactura=?;";
    private static final String ULTIMO_MES_FACTURADO= "SELECT * from adn.facturas where concepto='CUOTA' order by fecha_emision desc limit 1;";
    private static final String INSERTAR_NOTIFICACION = "INSERT INTO adn.notificaciones (`afiliadoced`,`fecha`) VALUES (?, ?)";

   
    public String facturacionMensual() throws ExcepcionConectar, ExcepcionInsertarFactura, ExcepcionCerrarConexion, ExcepcionListarAfiliados, ParseException, SQLException {
        ResultSet resultado=null;
        String mensaje=null;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Connection conexion = PersistenciaConexion.Conectar();
        PreparedStatement consultaPreparada = conexion.prepareStatement(ULTIMO_MES_FACTURADO);
        resultado = consultaPreparada.executeQuery();
        if(resultado.next()){
            Date fechaFacturaAnt = resultado.getDate("fecha_emision");
            SimpleDateFormat getAnio = new SimpleDateFormat("yyyy");
            String anio = getAnio.format(fechaFacturaAnt);
            SimpleDateFormat getMes = new SimpleDateFormat("MM");
            String mes = getMes.format(fechaFacturaAnt);
            
            int mesActual = Integer.parseInt(mes);  
            
            String fechaFacturacion = anio + "-" + mesActual + "-01";

              
            Afiliados afiliadosActivos = PersistenciaAfiliados.listarAfiliadosActivos();
        
        
        Date fechaFactura = formateador.parse(fechaFacturacion);
        PersistenciaTarifas persistenciaTarifas = new PersistenciaTarifas();
        Tarifa tarifa = persistenciaTarifas.getUltimaTarifa();
        for (int i=0; i<afiliadosActivos.size(); i++){
            try {
                Afiliado afiliado = afiliadosActivos.obtenerAfiliado(i);
                PreparedStatement insercionPreparada = conexion.prepareStatement(INSERTAR_FACTURA);
                insercionPreparada.setString(1, afiliado.getCedula());
                insercionPreparada.setDate(2, new java.sql.Date(fechaFactura.getTime()));
                insercionPreparada.setString(3, "CUOTA");
                insercionPreparada.setDouble(4, tarifa.getCuota());
                insercionPreparada.executeUpdate();
            } catch (SQLException ex) {
                throw new ExcepcionInsertarFactura("Error al insertar la factura");
            }finally { 
                PersistenciaConexion.cerrarConexion();
            }
        }
        }  
        
        mensaje = "Proceso finalizado";
        return mensaje;
    }    
    
    public void procesarBajas() throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionInactivarAfiliado {
        Connection conexion = PersistenciaConexion.Conectar();
      
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ATRASADOS_A_INACTIVAR);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("afiliadoced"));
                PersistenciaAfiliados.inactivarAfiliado(afiliado);
                
            }
           
        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("No se pudo modificar estado del afiliados");
        } finally {
            PersistenciaConexion.cerrarConexion();
        }        
    }   
    
    public  Facturas listarFacturasAfiliado(Afiliado afiliado) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionListarFacturas {
        ArrayList<Factura> listafacturas = new ArrayList<>();
        Facturas facturas = new Facturas();
        Connection conexion = PersistenciaConexion.Conectar();

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
            PersistenciaConexion.cerrarConexion();
        }
        return facturas;
    }
    
    public Facturas listarImpagasAfiliado(Afiliado afiliado) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionListarFacturas {
        ArrayList<Factura> listafacturas = new ArrayList<>();
        Facturas facturas = new Facturas();
        Connection conexion = PersistenciaConexion.Conectar();

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
            PersistenciaConexion.cerrarConexion();
        }
        return facturas;
    }

    private Date Date() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void procesarNotificacionesAtrasados() throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionInactivarAfiliado {
        Connection conexion = PersistenciaConexion.Conectar();
      
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ATRASADOS_A_NOTIFICAR);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("afiliadoced"));
                PersistenciaAfiliados.inactivarAfiliado(afiliado);
                
            }
           
        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("No se pudo modificar estado del afiliados");
        } finally {
            PersistenciaConexion.cerrarConexion();
        }        
    }   


    
}
