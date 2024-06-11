package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.horasExtras.rest.Backend_HorasExtras.dto.ProyectoDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IProyectoService;

@Controller
@RequestMapping("proyecto")
public class ControladorProyecto {

    @Autowired
    private IProyectoService servicio;

    // http://localhost:8081/proyecto/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<ProyectoDTO> proyectos = servicio.findAll();
        model.addAttribute("proyectos", proyectos);
        return "rest/index";
    }

    // http://localhost:8081/proyecto/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("proyecto", new ProyectoDTO());
        return "rest/form";
    }

    // http://localhost:8081/proyecto/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<ProyectoDTO> proyectoOpt = servicio.findById(id);
        if (proyectoOpt.isPresent()) {
            model.addAttribute("proyecto", proyectoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Proyecto no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/proyecto/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid ProyectoDTO p, Model model) {
        servicio.save(p);
        return "redirect:/admin/proyecto";
    }

    // http://localhost:8081/proyecto/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<ProyectoDTO> proyectoOpt = servicio.findById(id);
        if (proyectoOpt.isPresent()) {
            servicio.delete(proyectoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/proyecto";
    }

}