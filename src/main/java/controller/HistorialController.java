/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import org.springframework.stereotype.Controller;
import entity.Artista;
import entity.Historial;
import service.IHidtorialService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HistorialController {

    @Autowired
    private IHidtorialService historialService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Historial> listaEventos = historialService.getAllHistory();
        model.addAttribute("titulo", "Eventos");
        model.addAttribute("Eventos", listaEventos);
        return "home";
    }

    @GetMapping("/nuevoEvento")
    public String newEvento(Model model) {
        model.addAttribute("historial", new Historial());
        return "crear";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute Historial historial) {
        historialService.saveEvent(historial);
        return "redirect:/";
    }
       @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("artista") String artista) {
        historialService.delete(artista);
        return "redirect:/home";
}
}
