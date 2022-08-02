package persistencia;

import excepciones.ExcepcionCerrarConexion;
import excepciones.ExcepcionConectar;
import excepciones.ExcepcionConsultaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Usuario;


public class PersistenciaUsuarios {

    private static final String CONSULTA = "SELECT * FROM adn.usuarios WHERE usuario=? and clave=?;";

    public static String consultar(Usuario usuario) throws ExcepcionConsultaUsuario, ExcepcionConectar, ExcepcionCerrarConexion {
        String nombreUsuario = "";
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement ps = conexion.prepareStatement(CONSULTA);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getClave());
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                nombreUsuario = resultado.getString("nombre");
            }
        } catch (SQLException ex) {
            throw new ExcepcionConsultaUsuario("No se pudo consultar el usuario");
        }  finally {
            conectar.cerrarConexion();
        }
        return nombreUsuario;
    }

}
