package logica;

import excepciones.*;
import java.sql.Date;
import persistencia.*;

public class Logica {

    public String consultarUsuario(Usuario usuario) throws ExcepcionConsultaUsuario, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaUsuarios usuarios = new PersistenciaUsuarios();
        return usuarios.consultar(usuario);
    }

    public Afiliados listadoAfiliadosActivos() throws ExcepcionListarAfiliados, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        return afiliados.listarAfiliadosActivos();
    }

    public Afiliado consultaAfiliadoPorCedula(Afiliado afiliado) throws ExcepcionConsultaCedula, ExcepcionCedulaNoEncontrada, ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionNegocio {
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        return afiliados.consultaCedula(afiliado);
    }

    public String inactivarAfiliado(Afiliado afiliado) throws ExcepcionInactivarAfiliado, ExcepcionCerrarConexion, ExcepcionConectar {
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        return afiliados.inactivarAfiliado(afiliado);
    }

    public Negocios listaNegocios() throws ExcepcionNegocio, ExcepcionCerrarConexion, ExcepcionConectar {
        PersistenciaNegocios negocios = new PersistenciaNegocios();
        return negocios.listaNegocios();
    }

    public void insertarAfiliado(Afiliado afiliado) throws ExcepcionInsertarAfiliado, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        afiliados.insertarAfiliado(afiliado);
    }

    public void insertarAfiliacion(Afiliacion afiliacion) throws ExcepcionInsertarAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaAfiliacion afiliaciones = new PersistenciaAfiliacion();
        afiliaciones.insertar(afiliacion);
    }

    public Negocio consultarNegocioPorNombre(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaNegocios negocios = new PersistenciaNegocios();
        return negocios.consultarNegocioPorNombre(negocio);
    }

    public Negocio consultarNegocioPorId(Negocio negocio) throws ExcepcionNegocio, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaNegocios negocios = new PersistenciaNegocios();
        return negocios.consultarNegocioPorId(negocio);
    }

    public void editarAfiliado(Afiliado afiliado) throws ExcepcionAfiliado, ExcepcionConectar, ExcepcionCerrarConexion {
        PersistenciaAfiliados afiliados = new PersistenciaAfiliados();
        afiliados.editarAfiliado(afiliado);
    }
    
    public void borrarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionBorrarNegocio{
        PersistenciaNegocios negocios=new PersistenciaNegocios();
        negocios.borrarNegocio(negocio);
    }

    public void modificarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionCerrarConexion, ExcepcionModificarNegocio{
        PersistenciaNegocios negocios=new PersistenciaNegocios();
        negocios.modificarNegocio(negocio);
    }
    
    public void insertarNegocio(Negocio negocio) throws ExcepcionConectar, ExcepcionInsertarNegocio, ExcepcionCerrarConexion{
        PersistenciaNegocios negocios=new PersistenciaNegocios();
        negocios.insertarNegocio(negocio);
    }

    public Afiliaciones consultarAfiliacionesEntreFechas(Date desde, Date hasta) throws ExcepcionIConsultaAfiliacion, ExcepcionConectar, ExcepcionCerrarConexion{
        PersistenciaAfiliacion afiliaciones=new PersistenciaAfiliacion();
        return afiliaciones.consultarAfiliacionesEntreFechas(desde, hasta);
    }
    
    public void inactivarAfiliado(Afiliado afiliado, java.util.Date fechaBaja) throws ExcepcionConectar, ExcepcionInactivarAfiliado, ExcepcionCerrarConexion{
        PersistenciaAfiliados persistenciaAfiliados=new PersistenciaAfiliados();
        persistenciaAfiliados.inactivarAfiliado(afiliado, fechaBaja);
    }

}
