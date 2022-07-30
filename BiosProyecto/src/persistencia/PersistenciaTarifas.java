package persistencia;

import excepciones.*;
import java.sql.*;
import logica.Tarifa;
import java.util.Date;


public class PersistenciaTarifas {

    private static final String CONSULTA_FECHA = "SELECT * FROM adn.tarifas WHERE fecha=?;";
    private static final String ULTIMA_TARIFA = "SELECT * FROM adn.tarifas order by id desc limit 1;"; 
    
    public Tarifa getUltimaTarifa() throws ExcepcionConectar, ExcepcionCerrarConexion {
        ResultSet resultado = null;
        Connection conexion = PersistenciaConexion.Conectar();
        Tarifa tarifa = new Tarifa();
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(ULTIMA_TARIFA);
            resultado = consultaPreparada.executeQuery();
            
            if(resultado.next()){
                tarifa.setFecha(resultado.getDate("fecha"));
                tarifa.setMatricula(resultado.getDouble("matricula"));
                tarifa.setCuota(resultado.getDouble("cuota"));
            }
            
        } catch (SQLException ex) {
            throw new ExcepcionConectar("No se pudo realizar la consulta" );

        } finally {
            PersistenciaConexion.cerrarConexion();
        }
             
        return tarifa;
    }

       
}
