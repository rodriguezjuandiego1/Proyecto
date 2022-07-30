package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenciaConexion {
    
    private static Connection conexion;
    
    public static Connection Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/adn", "root", "password");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(PersistenciaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaConexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
