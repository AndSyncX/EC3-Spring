package idat.edu.pe.SpringEC3.model;

public class VendedorModel {
    private String nombre;
    private Double comision;
    private Double ventasmensuales;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getVentasmensuales() {
        return ventasmensuales;
    }

    public void setVentasmensuales(Double ventasmensuales) {
        this.ventasmensuales = ventasmensuales;
    }
}
