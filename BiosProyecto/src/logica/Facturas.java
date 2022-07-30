package logica;

import java.util.ArrayList;


public class Facturas {
    
    private ArrayList<Factura> lista = new ArrayList();

    public ArrayList<Factura> getListaFacturas() {
        return lista;
    }

    public void setListaFacturas(ArrayList<Factura> lista) {
        this.lista = lista;
    }
    
    public void agregarFactura(Factura factura){
        lista.add(factura);
    }
    
    
}