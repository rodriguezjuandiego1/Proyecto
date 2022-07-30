package persistencia;

import excepciones.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Afiliado;
import logica.Afiliados;

public class PersistenciaAfiliados {

    private static final String CONSULTA_ACTIVOS = "SELECT * FROM adn.afiliados WHERE estado='activo';";
    private static final String CONSULTA_CEDULA = "SELECT * FROM adn.afiliados WHERE cedula=? and estado='activo';";
    private static final String INACTIVAR = "UPDATE `adn`.`afiliados` SET `estado` = 'inactivo' WHERE (`cedula` = ?);";
    private static final String INSERTAR = "INSERT INTO `adn`.`afiliados` (`cedula`, `nombre`, `apellido`, "
            + "`nacionalidad`, `direccion`, `telefono`, `email`, `nacimiento`, `negocios_idNegocios`, `estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `adn`.`afiliados` SET `nombre` = ?, `apellido` = ?, `nacionalidad` = ?, `direccion` = ?,"
            + "`telefono` = ?, `email` = ?, `nacimiento` = ?, `negocios_idNegocios` = ? WHERE (`cedula` = ?);";

    public static Afiliados listarAfiliadosActivos() throws ExcepcionListarAfiliados {
        Afiliados afiliados = new Afiliados();
        Connection conexion = PersistenciaConexion.Conectar();
        try {
            PreparedStatement declaracionPreparada = conexion.prepareStatement(CONSULTA_ACTIVOS);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                Afiliado afiliado = new Afiliado();
                afiliado.setCedula(resultado.getString("cedula"));
                afiliado.setNombre(resultado.getString("nombre"));
                afiliado.setApellido(resultado.getString("apellido"));
                afiliados.setAfiliado(afiliado);
            }
        } catch (SQLException ex) {
            throw new ExcepcionListarAfiliados("ERROR Comuníquese con soporte");
        } finally {
            PersistenciaConexion.cerrarConexion();
        }
        return afiliados;
    }

    public static Afiliado consultaCedula(Afiliado afiliado) throws ExcepcionConsultaCedula, ExcepcionCedulaNoEncontrada {
        ResultSet resultado = null;
        Connection conexion = PersistenciaConexion.Conectar();
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
                afiliado.setNegocio(resultado.getString("negocios_idNegocios"));
                afiliado.setEstado(resultado.getString("estado"));
            }
            if (cedulaExiste == false) {
                throw new ExcepcionCedulaNoEncontrada("Cédula no encontrada");
            }
        } catch (SQLException ex) {
            throw new ExcepcionConsultaCedula("ERROR Comuníquese con soporte");

        } finally {
            PersistenciaConexion.cerrarConexion();
        }
        return afiliado;
    }

    public static String inactivarAfiliado(Afiliado afiliado) throws ExcepcionInactivarAfiliado {
        int x;
        String mensaje;
        try {
            Connection conexion = PersistenciaConexion.Conectar();
            PreparedStatement consultaPreparada = conexion.prepareStatement(INACTIVAR);

            consultaPreparada.setString(1, afiliado.getCedula());
            x = consultaPreparada.executeUpdate();
            if (x == 0) {
                mensaje = "No se pudo realizar la desafiliación";
            } else {
                mensaje = "Desafiliación realizada correctamente";
            }
        } catch (SQLException ex) {
            throw new ExcepcionInactivarAfiliado("ERROR Comuníquese con soporte");
        } finally {
            PersistenciaConexion.cerrarConexion();
        }
        return mensaje;

    }

    public static void insertarAfiliado(Afiliado afiliado) throws ExcepcionInsertarAfiliado {
        Connection conexion = PersistenciaConexion.Conectar();
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
            consultaPreparada.setString(9, afiliado.getNegocio());
            consultaPreparada.setString(10, afiliado.getEstado());
            consultaPreparada.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ExcepcionInsertarAfiliado("ERROR Comuníquese con soporte");
        } finally {
            PersistenciaConexion.cerrarConexion();
        }
    }

    public static void editarAfiliado(Afiliado afiliado) throws ExcepcionAfiliado {
        int registrosModificados;
        try {
            Connection conexion = PersistenciaConexion.Conectar();
            PreparedStatement consultaPreparada = conexion.prepareStatement(UPDATE);
            consultaPreparada.setString(1, afiliado.getNombre());
            consultaPreparada.setString(2, afiliado.getApellido());
            consultaPreparada.setString(3, afiliado.getNacionalidad());
            consultaPreparada.setString(4, afiliado.getDireccion());
            consultaPreparada.setString(5, afiliado.getTelefono());
            consultaPreparada.setString(6, afiliado.getEmail());
            String fecha = String.format("%1$tY-%1$tm-%1$td", afiliado.getNacimiento());
            consultaPreparada.setString(7, fecha);
            consultaPreparada.setString(8, afiliado.getNegocio());
            consultaPreparada.setString(9, afiliado.getCedula());
            registrosModificados=consultaPreparada.executeUpdate();
            if(registrosModificados==0){
                throw new SQLException();
            }
        } catch (SQLException ex) {
            throw new ExcepcionAfiliado("ERROR Comuníquese con soporte");
        } finally{
            PersistenciaConexion.cerrarConexion();
        }

    }
}