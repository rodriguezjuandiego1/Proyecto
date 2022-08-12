package persistencia;

import excepciones.*;
import java.sql.*;
import logica.Negocio;
import logica.Negocios;

public class PersistenciaNegocios {

    private final String CONSULTA_NEGOCIOS = "SELECT * FROM adn.negocios;";
    private final String CONSULTA_NEGOCIO_NOMBRE = "SELECT * FROM adn.negocios WHERE nombre=?;";
    private final String CONSULTA_NEGOCIO_ID = "SELECT * FROM adn.negocios WHERE idNegocios=?;";
    private final String INSERTAR = "INSERT INTO `adn`.`negocios` (`nombre`) VALUES (?);";
    private final String MODIFICAR="UPDATE `adn`.`negocios` SET `nombre` = ? WHERE (`idnegocios` = ?);";
    private final String BORRAR="DELETE FROM `adn`.`negocios` WHERE (`idnegocios` = ?);";

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
                negocios.agregarNegocio(negocio);
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
            }
        } catch (SQLException ex) {
            throw new ExcepcionNegocio("No se pudo consultar negocio por su id");
        } finally {
            conectar.cerrarConexion();
        }
        return negocioEncontrado;
    }

    public void insertarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionInsertarNegocio, ExcepcionCerrarConexion {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR);
            consultaPreparada.setString(1, negocio.getNombre());
            consultaPreparada.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ExcepcionInsertarNegocio("No se pudo agregar un nuevo negocio");
        } finally {
            conectar.cerrarConexion();
        }
    }
    
    public void modificarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionModificarNegocio{
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(MODIFICAR);
            consultaPreparada.setString(1, negocio.getNombre());
            consultaPreparada.setString(2, negocio.getId());
            consultaPreparada.executeUpdate();
        } catch (SQLException ex) {
            throw new ExcepcionModificarNegocio("No se pudo modificar el negocio");
        } finally {
            conectar.cerrarConexion();
        }
    }
    
    public void borrarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionBorrarNegocio{
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(BORRAR);
            consultaPreparada.setString(1, negocio.getId());
            consultaPreparada.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new ExcepcionBorrarNegocio("No se pudo borrar el negocio porque está vinculado a un afiliado");
        } catch (SQLException ex){
            throw new ExcepcionBorrarNegocio("No se pudo borrar el negocio");
        } finally {
            conectar.cerrarConexion();
        }
    }
    
}
