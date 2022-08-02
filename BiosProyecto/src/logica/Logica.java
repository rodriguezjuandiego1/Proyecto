
package logica;

import excepciones.ExcepcionAfiliado;
import excepciones.ExcepcionCedulaNoEncontrada;
import excepciones.ExcepcionCerrarConexion;
import excepciones.ExcepcionConectar;
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
    
    public String consultarUsuario (Usuario usuario) throws ExcepcionConsultaUsuario, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaUsuarios usuarios=new PersistenciaUsuarios();
        return usuarios.consultar(usuario);
    }
    
    public Afiliados listadoAfiliadosActivos() throws ExcepcionListarAfiliados, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliados afiliados=new PersistenciaAfiliados();
        return afiliados.listarAfiliadosActivos();
    }
    
    public Afiliado consultaAfiliadoPorCedula(Afiliado afiliado) throws  ExcepcionConsultaCedula, ExcepcionCedulaNoEncontrada, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        return afiliados.consultaCedula(afiliado);
    }
    
    public String inactivarAfiliado(Afiliado afiliado) throws ExcepcionInactivarAfiliado, ExcepcionCerrarConexion, ExcepcionConectar{
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        return afiliados.inactivarAfiliado(afiliado);
    }
    
    public Negocios listaNegocios() throws ExcepcionNegocio, ExcepcionCerrarConexion, ExcepcionConectar{
        PersistenciaNegocios negocios= new PersistenciaNegocios();
        return negocios.listaNegocios();
    }
    
    public void insertarAfiliado(Afiliado afiliado) throws ExcepcionInsertarAfiliado, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        afiliados.insertarAfiliado(afiliado);
    }
    
    public void insertarAfiliacion(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliacion afiliaciones=new PersistenciaAfiliacion();
        afiliaciones.insertar(afiliacion);
    }
    
    public Negocio consultarNegocioPorNombre(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaNegocios negocios= new PersistenciaNegocios();
        return negocios.consultarNegocioPorNombre(negocio);
    }

    public Negocio consultarNegocioPorId(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaNegocios negocios=new PersistenciaNegocios();
        return negocios.consultarNegocioPorId(negocio);
    }

    public void editarAfiliado(Afiliado afiliado) throws ExcepcionAfiliado, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliados afiliados=new PersistenciaAfiliados();
        afiliados.editarAfiliado(afiliado);
    }
}
