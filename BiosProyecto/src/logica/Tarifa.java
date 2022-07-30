
package logica;

import java.sql.Date;

public class Tarifa {

    private Integer id;
    private Date fecha;
    private Double matricula;
    private Double cuota;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMatricula() {
        return matricula;
    }

    public void setMatricula(Double matricula) {
        this.matricula = matricula;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
