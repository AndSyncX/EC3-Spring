package idat.edu.pe.SpringEC3.controller;

import idat.edu.pe.SpringEC3.model.PagoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagoController {

    @GetMapping("/pago")
    public String formularioPago(Model model) {
       model.addAttribute("pagomodel", new PagoModel());
       model.addAttribute("visualizaralerta", false);
       return "pago";
    }

    @PostMapping("/calcularbonificacion")
    public String calcularBonificacion(@ModelAttribute("pagomodel") PagoModel pago, Model model){
        Integer dias_para_pagar = pago.getDias_para_pagar();
        Double bonificacion = pago.getBonificacion();
        Double totalapagar = pago.getTotalapagar();
        String estilo = "alert-danger";

        if (dias_para_pagar < 7) {
            bonificacion = .1;
            estilo = "alert-primary";
        } else if (dias_para_pagar < 15) {
            bonificacion = .05;    estilo = "alert-warning";
        } else {
            bonificacion = .0;    estilo = "alert-danger";
        }

        totalapagar -= (totalapagar * bonificacion);

        int bonificacionInteger = (int) (bonificacion * 100);

        model.addAttribute("resultado", "Tu bonificación es del: " + bonificacionInteger + "% de descuento y el total a pagar es: " + totalapagar);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilo", estilo);
        return "pago";
    }
}
