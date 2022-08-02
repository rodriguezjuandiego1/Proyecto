package persistencia;

import excepciones.ExcepcionCerrarConexion;
import excepciones.ExcepcionConectar;
import excepciones.ExcepcionNegocio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Negocio;
import logica.Negocios;

public class PersistenciaNegocios {

    private final String CONSULTA_NEGOCIOS = "SELECT * FROM adn.negocios;";
    private final String CONSULTA_NEGOCIO_NOMBRE = "SELECT * FROM adn.negocios WHERE nombre=?;";
    private final String CONSULTA_NEGOCIO_ID = "SELECT * FROM adn.negocios WHERE idNegocios=?;";

    public Negocios listaNegocios() throws ExcepcionNegocio, ExcepcionCerrarConexion, ExcepcionConectar {
        Negocios negocios = new Negocios();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
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
        } catch (SQLException ex) {
            throw new ExcepcionNegocio("No se pudo listar los negocios");
        } finally {
            conectar.cerrarConexion();
        }
        return negocios;
    }

    public Negocio consultarNegocioPorNombre(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion {
        Negocio negocioEncontrado = new Negocio();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        PreparedStatement declaracionPreparada;
        try {
            declaracionPreparada = conexion.prepareStatement(CONSULTA_NEGOCIO_NOMBRE);
            declaracionPreparada.setString(1, negocio.getNombre());
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                negocioEncontrado.setId(resultado.getString("idNegocios"));
                negocioEncontrado.setNombre(resultado.getString("nombre"));
                negocioEncontrado.setId_rubro(resultado.getString("Rubros_idRubros"));
            }
        } catch (SQLException ex) {
            throw new ExcepcionNegocio("No se pudo consultar negocio por su nombre");
        } finally {
            conectar.cerrarConexion();
        }
        return negocioEncontrado;
    }

    public Negocio consultarNegocioPorId(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion {
        Negocio negocioEncontrado = new Negocio();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        PreparedStatement declaracionPreparada;
        try {
            declaracionPreparada = conexion.prepareStatement(CONSULTA_NEGOCIO_ID);
            declaracionPreparada.setString(1, negocio.getId());
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                negocioEncontrado.setId(resultado.getString("idNegocios"));
                negocioEncontrado.setNombre(resultado.getString("nombre"));
                negocioEncontrado.setId_rubro(resultado.getString("Rubros_idRubros"));
            }
        } catch (SQLException ex) {
            throw new ExcepcionNegocio("No se pudo consultar negocio por su id");
        } finally {
            conectar.cerrarConexion();
        }
        return negocioEncontrado;
    }
}
