
package logica;

import excepciones.ExcepcionAfiliado;
import excepciones.ExcepcionCedulaNoEncontrada;
import excepciones.ExcepcionConsultaCedula;
import excepciones.ExcepcionConsultaUsuario;
import excepciones.ExcepcionInactivarAfiliado;
import excepciones.ExcepcionInsertarAfiliacion;
import excepciones.ExcepcionInsertarAfiliado;
import excepciones.ExcepcionListarAfiliados;
import excepciones.ExcepcionNegocio;
import persistencia.PersistenciaAfiliacion;
import persistencia.PersistenciaAfiliados;
import persistencia.PersistenciaNegocios;
import persistencia.PersistenciaUsuarios;


public class Logica {
    
    public static String consultarUsuario (Usuario usuario) throws ExcepcionConsultaUsuario{
        return PersistenciaUsuarios.consultar(usuario);
    }
    
    public static Afiliados listadoAfiliadosActivos() throws ExcepcionListarAfiliados{
        return PersistenciaAfiliados.listarAfiliadosActivos();
    }
    
    public static Afiliado consultaAfiliadoPorCedula(Afiliado afiliado) throws  ExcepcionConsultaCedula, ExcepcionCedulaNoEncontrada{
        return PersistenciaAfiliados.consultaCedula(afiliado);
    }
    
    public static String inactivarAfiliado(Afiliado afiliado) throws ExcepcionInactivarAfiliado{
        return PersistenciaAfiliados.inactivarAfiliado(afiliado);
    }
    
    public static Negocios listaNegocios() throws ExcepcionNegocio{
        return PersistenciaNegocios.listaNegocios();
    }
    
    public static void insertarAfiliado(Afiliado afiliado) throws ExcepcionInsertarAfiliado{
        PersistenciaAfiliados.insertarAfiliado(afiliado);
    }
    
    public static void insertarAfiliacion(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion{
        PersistenciaAfiliacion.insertar(afiliacion);
    }
    
    public static Negocio consultarNegocioPorNombre(Negocio negocio) throws ExcepcionNegocio{
        return PersistenciaNegocios.consultarNegocioPorNombre(negocio);
    }

    public static Negocio consultarNegocioPorId(Negocio negocio) throws ExcepcionNegocio{
        return PersistenciaNegocios.consultarNegocioPorId(negocio);
    }

    public static void editarAfiliado(Afiliado afiliado) throws ExcepcionAfiliado{
        PersistenciaAfiliados.editarAfiliado(afiliado);
    }
}
