package persistencia;

import excepciones.*;
import java.sql.*;
import logica.Tarifa;

public class PersistenciaTarifas {

    private final String CONSULTA_FECHA = "SELECT * FROM adn.tarifas WHERE fecha=?;";
    private final String ULTIMA_TARIFA = "SELECT * FROM adn.tarifas order by id desc limit 1;";

    public Tarifa getUltimaTarifa() throws ExcepcionConectar, ExcepcionCerrarConexion {
        ResultSet resultado = null;
        PersistenciaConexion conectar = new PersistenciaConexion();
        Connection conexion = conectar.Conectar();
        Tarifa tarifa = new Tarifa();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(ULTIMA_TARIFA);
            resultado = consultaPreparada.executeQuery();

            if (resultado.next()) {
                tarifa.setFecha(resultado.getDate("fecha"));
                tarifa.setMatricula(resultado.getDouble("matricula"));
                tarifa.setCuota(resultado.getDouble("cuota"));
            }

        } catch (SQLException ex) {
            throw new ExcepcionConectar("No se pudo realizar la consulta");

        } finally {
            conectar.cerrarConexion();
        }

        return tarifa;
    }

}
