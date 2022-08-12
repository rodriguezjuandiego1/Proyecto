package persistencia;

import excepciones.*;
import java.sql.*;
import logica.*;

public class PersistenciaAfiliados {

    private final String CONSULTA_ACTIVOS = "SELECT * FROM adn.afiliados WHERE estado='activo';";
    private final String CONSULTA_CEDULA = "SELECT * FROM adn.afiliados WHERE cedula=? and estado='activo';";
    private final String INACTIVAR = "UPDATE `adn`.`afiliados` SET `estado` = 'inactivo' WHERE (`cedula` = ?);";
    private final String INSERTAR = "INSERT INTO `adn`.`afiliados` (`cedula`, `nombre`, `apellido`, "
            + "`nacionalidad`, `direccion`, `telefono`, `email`, `nacimiento`, `negocios_idNegocios`, `estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE `adn`.`afiliados` SET `nombre` = ?, `apellido` = ?, `nacionalidad` = ?, `direccion` = ?,"
            + "`telefono` = ?, `email` = ?, `nacimiento` = ?, `negocios_idNegocios` = ? WHERE (`cedula` = ?);";
    private final String DAR_DE_BAJA = "UPDATE `adn`.`afiliados` SET `estado` = 'inactivo', `fecha_baja` = ? WHERE (`cedula` = ?);";

    
    
    public Afiliados listarAfiliadosActivos() throws ExcepcionListarAfiliados, ExcepcionConectar, ExcepcionCerrarConexion {

        Afiliados afiliados = new Afiliados();
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ACTIVOS);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("cedula"));
                afiliado.setNombre(resultado.getString("nombre"));
                afiliado.setApellido(resultado.getString("apellido"));
                afiliados.agregarAfiliado(afiliado);
            }
        } catch (SQLException ex) {
            throw new ExcepcionListarAfiliados("No se pudo listar los afiliados activos");
        } finally {
            conectar.cerrarConexion();
        }
        return afiliados;
    }

    public Afiliado consultaCedula(Afiliado afiliado) throws ExcepcionConsultaCedula, ExcepcionCedulaNoEncontrada, ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionNegocio {
        ResultSet resultado = null;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(CONSULTA_CEDULA);
            consultaPreparada.setString(1, afiliado.getCedula());
            resultado = consultaPreparada.executeQuery();
            boolean cedulaExiste = false;
            while (resultado.next()) {
                cedulaExiste = true;
                afiliado.setCedula(resultado.getString("cedula"));
                afiliado.setNombre(resultado.getString("nombre"));
                afiliado.setApellido(resultado.getString("apellido"));
                afiliado.setNacionalidad(resultado.getString("nacionalidad"));
                afiliado.setDireccion(resultado.getString("direccion"));
                afiliado.setTelefono(resultado.getString("telefono"));
                afiliado.setEmail(resultado.getString("email"));
                afiliado.setNacimiento(resultado.getDate("nacimiento"));
                Negocio negocio=new Negocio();
                negocio.setId(resultado.getString("negocios_idNegocios"));
                PersistenciaNegocios persistenciaNegocios=new PersistenciaNegocios();
                afiliado.setNegocio(persistenciaNegocios.consultarNegocioPorId(negocio));
                afiliado.setEstado(resultado.getString("estado"));
            }
            if (cedulaExiste == false) {
                throw new ExcepcionCedulaNoEncontrada("Cédula no encontrada");
            }
        } catch (SQLException ex) {
            throw new ExcepcionConsultaCedula("No se pudo consultar cédula");

        } finally {
            conectar.cerrarConexion();
        }
        return afiliado;
    }

    public String inactivarAfiliado(Afiliado afiliado) throws ExcepcionInactivarAfiliado, ExcepcionConectar, ExcepcionCerrarConexion {
        int resultado;
        String mensaje;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement consultaPreparada = conexion.prepareStatement(INACTIVAR);

            consultaPreparada.setString(1, afiliado.getCedula());
            resultado = consultaPreparada.executeUpdate();
            if (resultado == 0) {
                mensaje = "No se pudo realizar la desafiliación";
            } else {
                mensaje = "Desafiliación realizada correctamente";
            }
        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("No se pudo realizar la desafiliación");
        } finally {
            conectar.cerrarConexion();
        }
        return mensaje;

    }
    
    public void insertarAfiliado(Afiliado afiliado) throws ExcepcionInsertarAfiliado, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR);
            consultaPreparada.setString(1, afiliado.getCedula());
            consultaPreparada.setString(2, afiliado.getNombre());
            consultaPreparada.setString(3, afiliado.getApellido());
            consultaPreparada.setString(4, afiliado.getNacionalidad());
            consultaPreparada.setString(5, afiliado.getDireccion());
            consultaPreparada.setString(6, afiliado.getTelefono());
            consultaPreparada.setString(7, afiliado.getEmail());
            String fecha = String.format("%1$tY-%1$tm-%1$td", afiliado.getNacimiento());
            consultaPreparada.setString(8, fecha);
            consultaPreparada.setString(9, afiliado.getNegocio().getId());
            consultaPreparada.setString(10, afiliado.getEstado());
            consultaPreparada.executeUpdate();

        } catch (SQLException ex) {
            throw new ExcepcionInsertarAfiliado("No se pudo insertar un nuevo afiliado");
        } finally {
            conectar.cerrarConexion();
        }
    }

    public void editarAfiliado(Afiliado afiliado) throws ExcepcionAfiliado, ExcepcionConectar, ExcepcionCerrarConexion {
        int registrosModificados;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement consultaPreparada = conexion.prepareStatement(UPDATE);
            consultaPreparada.setString(1, afiliado.getNombre());
            consultaPreparada.setString(2, afiliado.getApellido());
            consultaPreparada.setString(3, afiliado.getNacionalidad());
            consultaPreparada.setString(4, afiliado.getDireccion());
            consultaPreparada.setString(5, afiliado.getTelefono());
            consultaPreparada.setString(6, afiliado.getEmail());
            String fecha = String.format("%1$tY-%1$tm-%1$td", afiliado.getNacimiento());
            consultaPreparada.setString(7, fecha);
            consultaPreparada.setString(8, afiliado.getNegocio().getId());
            consultaPreparada.setString(9, afiliado.getCedula());
            registrosModificados = consultaPreparada.executeUpdate();
            if (registrosModificados == 0) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new ExcepcionAfiliado("ERROR Comuníquese con soporte");
        } finally {
            conectar.cerrarConexion();
        }

    }

    public void inactivarAfiliado(Afiliado afiliado, java.util.Date fechaBaja) throws ExcepcionConectar, ExcepcionInactivarAfiliado, ExcepcionCerrarConexion {
        int resultado;
        //String mensaje;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement consultaPreparada = conexion.prepareStatement(DAR_DE_BAJA);
            consultaPreparada.setDate(1, new java.sql.Date(fechaBaja.getTime())); 
            consultaPreparada.setString(2, afiliado.getCedula());
            

             resultado = consultaPreparada.executeUpdate();
//            if (resultado == 0) {
//                mensaje = "No se pudo realizar la desafiliación";
//            } else {
//                mensaje = "Desafiliación realizada correctamente";
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ExcepcionInactivarAfiliado("No se pudo dar de baja");
        } finally {
            conectar.cerrarConexion();
        }
        //return mensaje;
    }
    
}
