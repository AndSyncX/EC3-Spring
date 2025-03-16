package idat.edu.pe.SpringEC3.controller;

import idat.edu.pe.SpringEC3.model.ProductoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @GetMapping("/producto")
    public String formularioProducto(Model model) {
        model.addAttribute("productomodel", new ProductoModel());
        model.addAttribute("visualizaralerta", false);
        return  "producto";
    }

    @PostMapping("calcularimpuesto")
    public String calcularImpuesto(@ModelAttribute("productomodel") ProductoModel producto, Model model) {
        String categoria = producto.getCategoria().toUpperCase();
        Double precio_base = producto.getPrecio_base();
        Double impuesto = producto.getImpuesto();
        Double precio_final = producto.getPrecio_final();
        String estilo = "alert-danger";

        if (categoria.equals("ELECTRONICA")) {
            impuesto = .15;
            estilo = "alert-warning";
        } else if (categoria.equals("ALIMENTOS")) {
            impuesto = .05;
            estilo = "alert-dark";
        } else if (categoria.equals("ROPA")) {
            impuesto = .08;
            estilo = "alert-primary";
        } else if (categoria.equals("MUEBLES")) {
            impuesto = .1;
            estilo = "alert-danger";
        }

        precio_final = precio_base + (precio_base * impuesto);

        int impuestoInteger = (int) (impuesto * 100);

        model.addAttribute("resultado", categoria + " --> Impuesto del: "+ impuestoInteger + "% y el precio final es: $" + precio_final);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilo", estilo);
        return "producto";
    }
}
