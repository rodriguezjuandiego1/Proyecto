package persistencia;

import excepciones.*;
import java.sql.*;
import logica.*;

public class PersistenciaAfiliacion {

    private String INSERTAR = "INSERT INTO `adn`.`afiliaciones` (`fecha`, `Afiliados_cedula`) VALUES (?, ?);";
    private String CONSULTA="SELECT * FROM adn.afiliaciones JOIN adn.afiliados ON "
            + "Afiliados_cedula=cedula where fecha>? && fecha<?;";
    
    
    public void insertar(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR);
            String fechaString = String.format("%1$tY-%1$tm-%1$td", afiliacion.getFecha());
            consultaPreparada.setString(1, fechaString);
            consultaPreparada.setString(2, afiliacion.getAfiliado().getCedula());
            consultaPreparada.executeUpdate();
        } catch (SQLException ex) {
            throw new ExcepcionInsertarAfiliacion("No se pudo insertar la afiliación");
        } finally {
            conectar.cerrarConexion();
        }

    }
    
    public Afiliaciones consultarAfiliacionesEntreFechas(Date desde, Date hasta) throws ExcepcionIConsultaAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        Afiliaciones afiliaciones=new Afiliaciones();
        
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(CONSULTA);
            String fechaDesdeString = String.format("%1$tY-%1$tm-%1$td", desde);
            String fechaHastaString = String.format("%1$tY-%1$tm-%1$td", hasta);
            consultaPreparada.setString(1, fechaDesdeString);
            consultaPreparada.setString(2, fechaHastaString);
            ResultSet resultado=consultaPreparada.executeQuery();
            while(resultado.next()){
                Afiliado afiliado=new Afiliado();
                afiliado.setCedula(resultado.getString("cedula"));
                afiliado.setNombre(resultado.getString("nombre"));
                afiliado.setApellido(resultado.getString("apellido"));
                
                Afiliacion afiliacion=new Afiliacion();
                afiliacion.setFecha(Date.valueOf(resultado.getString("fecha")));
                afiliacion.setAfiliado(afiliado);
                
                afiliaciones.agregarAfiliacion(afiliacion);
            }
        } catch (SQLException ex) {
            throw new ExcepcionIConsultaAfiliacion("No se pudo consultar las afiliaciones");
        } finally {
            conectar.cerrarConexion();
        }
        return afiliaciones;
    }
    
}
