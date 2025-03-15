package idat.edu.pe.SpringEC3.controller;

import idat.edu.pe.SpringEC3.model.ClienteModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @GetMapping("/cliente")
    public String formularioCliente(Model model) {
        model.addAttribute("clientemodel", new ClienteModel());
        model.addAttribute("visualizaralerta", false);
        return "cliente";
    }

    @PostMapping("calculardescuento")
    public String calcularDescuento(@ModelAttribute("clientemodel") ClienteModel cliente, Model model) {
        String nombre = cliente.getNombre();
        Integer antiguedad = cliente.getTiempo();
        Double descuento = cliente.getDescuento();
        Double totalpagar = cliente.getTotalapagar();
        String estilo = "alert-danger";

        if (antiguedad < 1) {
            descuento = .02;
            estilo = "alert-danger";
        } else if (antiguedad < 3) {
            descuento = .05;
            estilo = "alert-dark";
        } else if (antiguedad < 5 ) {
            descuento = .08;
            estilo = "alert-warning";
        } else {
            descuento = .12;
            estilo = "alert-primary";
        }

        totalpagar -= totalpagar * descuento;

        int descuentoInteger = (int) (descuento * 100);

        model.addAttribute("resultado", nombre + " tu descuento es del : " + descuentoInteger + "% y el total a pagar es: $" + totalpagar);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilo", estilo);
        return "cliente";
    }
}

