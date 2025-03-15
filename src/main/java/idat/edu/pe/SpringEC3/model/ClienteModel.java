package idat.edu.pe.SpringEC3.model;

public class ClienteModel {
    private String nombre;
    private Integer tiempo;  // En años
    private Double descuento;
    private Double totalapagar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(Double totalapagar) {
        this.totalapagar = totalapagar;
    }
}
