package persistencia;
//prueba
import excepciones.ExcepcionInsertarAfiliacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Afiliacion;

public class PersistenciaAfiliacion {

    private static String INSERTAR = "INSERT INTO `adn`.`afiliaciones` (`fecha`, `Afiliados_cedula`) VALUES (?, ?);";

    public static void insertar(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion {
        
        try {
            Connection conexion = PersistenciaConexion.Conectar();
            PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR);
            String fechaString = String.format("%1$tY-%1$tm-%1$td", afiliacion.getFecha());
            consultaPreparada.setString(1, fechaString);
            consultaPreparada.setString(2, afiliacion.getCedula());
            consultaPreparada.executeUpdate();
        } 
        catch (SQLException ex) {        
            Logger.getLogger(PersistenciaAfiliacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionInsertarAfiliacion("ERROR Comuníquese con soporte");
        }        
        finally{
            PersistenciaConexion.cerrarConexion();
        }
        
    }

}
