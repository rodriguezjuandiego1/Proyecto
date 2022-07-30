
package logica;

import java.util.ArrayList;


public class Afiliados {
    
    private ArrayList<Afiliado> lista = new ArrayList();

    public ArrayList<Afiliado> getListaAfiliados() {
        return lista;
    }

    
    public void setAfiliado(Afiliado afiliado){
        lista.add(afiliado);
    }
    
    
}
