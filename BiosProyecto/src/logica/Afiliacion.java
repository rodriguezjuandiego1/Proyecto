
package logica;

import java.sql.Date;

public class Afiliacion {
    
    private Date fecha;
    private Afiliado afiliado;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    
    
}
