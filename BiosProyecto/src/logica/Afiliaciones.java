
package logica;

import java.util.ArrayList;


public class Afiliaciones {
    
    private ArrayList<Afiliacion> afiliaciones=new ArrayList();
    
    public ArrayList<Afiliacion> getAfiliaciones(){
        return afiliaciones;
    } 
    
    public void agregarAfiliacion(Afiliacion afiliacion){
        afiliaciones.add(afiliacion);
    }
    
}
