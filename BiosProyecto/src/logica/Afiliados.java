
package logica;

import java.util.ArrayList;


public class Afiliados {
    
    private ArrayList<Afiliado> lista = new ArrayList();

    public ArrayList<Afiliado> getListaAfiliados() {
        return lista;
    }

    
    public void agregarAfiliado(Afiliado afiliado){
        lista.add(afiliado);
    }

    public int size() {
        return lista.size();
       
    }

    public Afiliado obtenerAfiliado(int i) {
        return lista.get(i);
    }
    
    
}
