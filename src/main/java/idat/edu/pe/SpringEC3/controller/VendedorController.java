package idat.edu.pe.SpringEC3.controller;

import idat.edu.pe.SpringEC3.model.VendedorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendedorController {

    @GetMapping("/vendedor")
    public String formularioVendedor(Model model) {
        model.addAttribute("vendedormodel", new VendedorModel());
        model.addAttribute("visualizaralerta", false);
        return "vendedor";
    }

    @PostMapping("/calcularcomision")
    public String calcularComision(@ModelAttribute("vendedormodel")VendedorModel vendedor, Model model) {
        String nombre = vendedor.getNombre();
        Double comision = vendedor.getComision();
        Double ventas = vendedor.getVentasmensuales();
        String estilo = "alert-danger";

        if (ventas < 1000) {
            comision = ventas * .03;
            estilo = "alert-danger";
        } else if (ventas < 5000) {
            comision = ventas * .05;
            estilo = "alert-dark";
        } else if (ventas < 10000) {
            comision = ventas * .07;
            estilo = "alert-warning";
        } else {
            comision = ventas * .1;
            estilo = "alert-primary";
        }

        model.addAttribute("resultado", nombre + " su comisión es : $" + String.format("%.2f", comision));
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilo", estilo);
        return "vendedor";
    }
}