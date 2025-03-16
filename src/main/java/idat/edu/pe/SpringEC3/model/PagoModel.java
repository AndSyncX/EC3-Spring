package idat.edu.pe.SpringEC3.model;

public class PagoModel {
    private Integer dias_para_pagar;
    private Double bonificacion;
    private Double totalapagar;

    public Integer getDias_para_pagar() {
        return dias_para_pagar;
    }

    public void setDias_para_pagar(Integer dias_para_pagar) {
        this.dias_para_pagar = dias_para_pagar;
    }

    public Double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Double getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(Double totalapagar) {
        this.totalapagar = totalapagar;
    }
}
