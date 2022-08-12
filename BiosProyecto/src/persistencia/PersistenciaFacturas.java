package persistencia;

import excepciones.ExcepcionInsertarNotificacion;
import excepciones.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import logica.*;

 
public class PersistenciaFacturas {
    private  final String CONSULTA_MENSUAL = "select * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private  final String CONSULTA_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? ;";
    private  final String CONSULTA_ATRASADOS_A_INACTIVAR = "SELECT * FROM adn.facturas WHERE fecha_pago is null group by afiliadoced having count(*)>2;";
    private  final String CONSULTA_ATRASADOS_A_NOTIFICAR = "SELECT * FROM adn.facturas WHERE fecha_pago is null group by afiliadoced having count(*)>1;";
    private  final String CONSULTA_IMPAGAS_AFILIADO = "SELECT * FROM adn.facturas WHERE afiliadoced=? and fecha_pago is null;";
    private  final String DELETE_MENSUAL = "delete * from adn.facturas where month(fecha_emision)=? and year(fecha_emision)=?;";
    private  final String DELETE_AFILIADO = "delete * from adn.facturas where afiliadoced=? and concepto='cuota' and month(fecha_emision)=? and year(fecha_emision)=?;";
    private  final String INSERTAR_FACTURA = "INSERT INTO adn.facturas (`afiliadoced`,`fecha_emision`, `concepto`, `importe`) VALUES (?, ?, ?, ?)";
    private  final String PAGAR_FACTURA = "UPDATE adn.facturas SET `fecha_pago` = ? WHERE idfactura=?;";
    private  final String ULTIMO_MES_FACTURADO= "SELECT * from adn.facturas where concepto='CUOTA' order by fecha_emision desc limit 1;";
    private  final String INSERTAR_NOTIFICACION = "INSERT INTO adn.notificaciones (`afiliadoced`,`fecha`) VALUES (?,?);";

    public Date nuevaFechaFacturacion() throws ExcepcionConectar, SQLException, ParseException{
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        ResultSet resultado=null; 
        Date fechaFactura = null;
        String fechaFacturacion = null;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement consultaPreparada = conexion.prepareStatement(ULTIMO_MES_FACTURADO);
        resultado = consultaPreparada.executeQuery();
        if(resultado.next()){
            Date fechaFacturaAnt = resultado.getDate("fecha_emision");
            SimpleDateFormat getAnio = new SimpleDateFormat("yyyy");
            String anio = getAnio.format(fechaFacturaAnt);
            SimpleDateFormat getMes = new SimpleDateFormat("MM");
            String mes = getMes.format(fechaFacturaAnt);
            int mesActual = Integer.parseInt(mes) + 1;  
            fechaFacturacion = anio + "-" + mesActual + "-01";
            fechaFactura = formateador.parse(fechaFacturacion);
        }
        System.out.println(fechaFactura);
        return fechaFactura;
    }    

    public String facturacionMensual(Date fechaFactura) throws ExcepcionConectar, ExcepcionInsertarFactura, ExcepcionCerrarConexion, ExcepcionListarAfiliados, ParseException, SQLException {
        ResultSet resultado=null;
        String mensaje=null;
        int cant=0;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PersistenciaAfiliados persistenciaAfiliados = new PersistenciaAfiliados();  
            Afiliados afiliadosActivos = persistenciaAfiliados.listarAfiliadosActivos();
            PersistenciaTarifas persistenciaTarifas = new PersistenciaTarifas();
            Tarifa tarifa = persistenciaTarifas.getUltimaTarifa();
            for (int i=0; i<afiliadosActivos.size(); i++){
                Afiliado afiliado = afiliadosActivos.obtenerAfiliado(i);
                PreparedStatement insercionPreparada = conexion.prepareStatement(INSERTAR_FACTURA);
                insercionPreparada.setString(1, afiliado.getCedula());
                insercionPreparada.setDate(2, new java.sql.Date(fechaFactura.getTime()));
                insercionPreparada.setString(3, "CUOTA");
                insercionPreparada.setDouble(4, tarifa.getCuota());
                insercionPreparada.executeUpdate();
                cant++;
            }    
        } catch (SQLException ex) {
            throw new ExcepcionInsertarFactura("Error al crear la factura.");
        } finally {
            conectar.cerrarConexion();
        } 
        mensaje = "Facturas creadas:" + cant + ".\n";
        return mensaje;
    }   

    public String agregarFactura(Afiliado afiliado, Date fechaFactura, String concepto) throws ExcepcionConectar, ExcepcionInsertarFactura, ExcepcionCerrarConexion, ExcepcionListarAfiliados, ParseException, SQLException {
        String mensaje=null;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PersistenciaAfiliados persistenciaAfiliados = new PersistenciaAfiliados();  
            PersistenciaTarifas persistenciaTarifas = new PersistenciaTarifas();
            Tarifa tarifa = persistenciaTarifas.getUltimaTarifa();
            PreparedStatement insercionPreparada = conexion.prepareStatement(INSERTAR_FACTURA);
            insercionPreparada.setString(1, afiliado.getCedula());
            insercionPreparada.setDate(2, new java.sql.Date(fechaFactura.getTime()));
            if (concepto=="MATRICULA"){
                insercionPreparada.setString(3, "MATRICULA");
                insercionPreparada.setDouble(4, tarifa.getMatricula());
            }else if (concepto=="CUOTA") {
                insercionPreparada.setString(3, "CUOTA");
                insercionPreparada.setDouble(4, tarifa.getCuota());
            }
            insercionPreparada.executeUpdate();
            mensaje = "Factura creada correctamente.";
        } catch (SQLException ex) {
            throw new ExcepcionInsertarFactura("Error al crear la factura.");
        } finally {
            conectar.cerrarConexion();
        } 
        return mensaje;   
    }    

    
    /**
     *
     * @param fechaBaja
     * @return
     * @throws ExcepcionConectar
     * @throws ExcepcionCerrarConexion
     * @throws ExcepcionInactivarAfiliado
     */
    public String procesarBajas(Date fechaBaja) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionInactivarAfiliado {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        String mensaje = null;
        int cant = 0;
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ATRASADOS_A_INACTIVAR);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("afiliadoced"));
                PersistenciaAfiliados persistenciaAfiliados = new PersistenciaAfiliados();  
                persistenciaAfiliados.inactivarAfiliado(afiliado,fechaBaja);
                cant++;
            }
        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("No se pudo modificar estado del afiliados");
        } finally {
            conectar.cerrarConexion();
        } 
        mensaje = "Bajas realizadas:" + cant + ".\n";
        return mensaje;
    }   
    
    public  Facturas listarFacturasAfiliado(Afiliado afiliado) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionListarFacturas {
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
            throw new ExcepcionListarFacturas("No se pudo listar facturas.");
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

        
    public String procesarNotificacionesAtrasados() throws ExcepcionConectar, ParseException, ExcepcionCerrarConexion, ExcepcionInsertarNotificacion {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        int cant=0;
        String mensaje=null;
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montevideo" ) );  // Use proper "continent/region" time zone names; never use 3-4 letter codes like "EST" or "IST".
        java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
         
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ATRASADOS_A_NOTIFICAR);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                PreparedStatement insercionPreparada = conexion.prepareStatement(INSERTAR_NOTIFICACION);
                insercionPreparada.setString(1, resultado.getString("afiliadoced"));
                insercionPreparada.setDate(2, sqlDate);
                insercionPreparada.executeUpdate();
                cant++;                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ExcepcionInsertarNotificacion("No se pudo insertar notificacion");
        } finally {
            conectar.cerrarConexion();
        } 
        return ("Notificaciones enviadas por atrasos: " + cant + ".\n");
        
    }   
}
