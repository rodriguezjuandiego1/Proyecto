package persistencia;

import excepciones.ExcepcionCerrarConexion;
import excepciones.ExcepcionConectar;
import excepciones.ExcepcionInsertarAfiliacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Afiliacion;

public class PersistenciaAfiliacion {

    private String INSERTAR = "INSERT INTO `adn`.`afiliaciones` (`fecha`, `Afiliados_cedula`) VALUES (?, ?);";

    public void insertar(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        try {

            PreparedStatement consultaPreparada = conexion.prepareStatement(INSERTAR);
            String fechaString = String.format("%1$tY-%1$tm-%1$td", afiliacion.getFecha());
            consultaPreparada.setString(1, fechaString);
            consultaPreparada.setString(2, afiliacion.getCedula());
            consultaPreparada.executeUpdate();
        } catch (SQLException ex) {
            throw new ExcepcionInsertarAfiliacion("No se pudo insertar la afiliación");
        } finally {
            conectar.cerrarConexion();
        }

    }

}
