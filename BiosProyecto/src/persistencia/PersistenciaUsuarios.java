package persistencia;

import excepciones.ExcepcionConsultaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;


public class PersistenciaUsuarios {

    private static final String CONSULTA = "SELECT * FROM adn.usuarios WHERE usuario=? and clave=?;";

    public static String consultar(Usuario usuario) throws ExcepcionConsultaUsuario {
        String nombreUsuario = "";
        Connection con = PersistenciaConexion.Conectar();
        try {
            PreparedStatement ps = con.prepareStatement(CONSULTA);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getClave());
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                nombreUsuario = resultado.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionConsultaUsuario("ERROR Comuníquese con soporte");
        }  finally {
            PersistenciaConexion.cerrarConexion();
        }
        return nombreUsuario;
    }

}
