package logica;

import java.sql.Date;


public class Factura {
    
    private Integer identificador;
    private String cedulaAfiliado;
    private Date fechaEmision;
    private String concepto;
    private Double importe;
    private Date fechaPago;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCedulaAfiliado() {
        return cedulaAfiliado;
    }

    public void setCedulaAfiliado(String cedulaAfiliado) {
        this.cedulaAfiliado = cedulaAfiliado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

 }
