
package logica;

import java.util.ArrayList;

public class Negocios {
    
    ArrayList <Negocio> negocios= new ArrayList<>();

    public ArrayList<Negocio> getNegocios() {
        return negocios;
    }

        
    public void agregarNegocio(Negocio negocio){
        negocios.add(negocio);
    }
    
    
    
}
