package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IHorasExtrasService;

@Controller
@RequestMapping("horasextras")
public class ControladorHorasExtras {

    @Autowired
    private IHorasExtrasService servicio;

    // http://localhost:8080/horasextras/listar/REST
    @ResponseBody
    @GetMapping("listar/REST")
    public List<HorasExtrasDTO> getAllHorasExtrasDTO(){
        return servicio.findAll();
    }

    // http://localhost:8081/horasextras/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("horasextras", new HorasExtrasDTO());
        return "rest/form";
    }

    // http://localhost:8081/horasextras/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<HorasExtrasDTO> horasextrasOpt = servicio.findById(id);
        if (horasextrasOpt.isPresent()) {
            model.addAttribute("horasextras", horasextrasOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Horas Extras no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/horasextras/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid HorasExtrasDTO h, Model model) {
        servicio.save(h);
        return "redirect:/admin/horasextras";
    }

    // http://localhost:8081/horasextras/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<HorasExtrasDTO> horasextrasOpt = servicio.findById(id);
        if (horasextrasOpt.isPresent()) {
            servicio.delete(horasextrasOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/horasextras";
    }

}