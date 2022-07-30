package persistencia;

import excepciones.ExcepcionNegocio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Negocio;
import logica.Negocios;

public class PersistenciaNegocios {

    private static final String CONSULTA_NEGOCIOS = "SELECT * FROM adn.negocios;";
    private static final String CONSULTA_NEGOCIO_NOMBRE = "SELECT * FROM adn.negocios WHERE nombre=?;";
    private static final String CONSULTA_NEGOCIO_ID = "SELECT * FROM adn.negocios WHERE idNegocios=?;";

    public static Negocios listaNegocios() throws ExcepcionNegocio{
        Negocios negocios = new Negocios();
        Connection conexion = PersistenciaConexion.Conectar();
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_NEGOCIOS);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Negocio negocio = new Negocio();
                negocio.setId(resultado.getString("idNegocios"));
                negocio.setNombre(resultado.getString("nombre"));
                negocio.setId_rubro(resultado.getString("Rubros_idRubros"));
                negocios.setNegocio(negocio);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PersistenciaNegocios.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("ERROR Comuníquese con soporte");
        } 
        finally {
            PersistenciaConexion.cerrarConexion();
        }
        return negocios;
    }

    public static Negocio consultarNegocioPorNombre(Negocio negocio) throws ExcepcionNegocio {
        Negocio negocioEncontrado = new Negocio();
        Connection conexion = PersistenciaConexion.Conectar();
        PreparedStatement declaracionPreparada;
        try {
            declaracionPreparada = conexion.prepareStatement(CONSULTA_NEGOCIO_NOMBRE);
            declaracionPreparada.setString(1, negocio.getNombre());
            ResultSet resultado = declaracionPreparada.executeQuery();
            while(resultado.next()){
                negocioEncontrado.setId(resultado.getString("idNegocios"));
                negocioEncontrado.setNombre(resultado.getString("nombre"));
                negocioEncontrado.setId_rubro(resultado.getString("Rubros_idRubros"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaNegocios.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("ERROR Comuníquese con soporte");
        }  finally{
            PersistenciaConexion.cerrarConexion();
        }
        return negocioEncontrado;
    }
    
    public static Negocio consultarNegocioPorId(Negocio negocio) throws ExcepcionNegocio {
        Negocio negocioEncontrado = new Negocio();
        Connection conexion = PersistenciaConexion.Conectar();
        PreparedStatement declaracionPreparada;
        try {
            declaracionPreparada = conexion.prepareStatement(CONSULTA_NEGOCIO_ID);
            declaracionPreparada.setString(1, negocio.getId());
            ResultSet resultado = declaracionPreparada.executeQuery();
            while(resultado.next()){
                negocioEncontrado.setId(resultado.getString("idNegocios"));
                negocioEncontrado.setNombre(resultado.getString("nombre"));
                negocioEncontrado.setId_rubro(resultado.getString("Rubros_idRubros"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaNegocios.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("ERROR Comuníquese con soporte");
        }  finally{
            PersistenciaConexion.cerrarConexion();
        }
        return negocioEncontrado;
    }
}
