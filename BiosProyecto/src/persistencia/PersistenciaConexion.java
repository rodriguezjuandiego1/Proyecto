package persistencia;

import excepciones.ExcepcionCerrarConexion;
import excepciones.ExcepcionConectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PersistenciaConexion {
    
    private Connection conexion;
    
    public Connection Conectar() throws ExcepcionConectar {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/adn", "root", "password");
        } catch (SQLException ex) {
            throw new ExcepcionConectar("Error al conectar a la base de datos");
        }
        return conexion;
    }
    
    public void cerrarConexion() throws ExcepcionCerrarConexion{
        try {
            conexion.close();
        } catch (SQLException ex) {
            throw new ExcepcionCerrarConexion("Error al cerrar conexión con base de datos");
        } 
    }

}
