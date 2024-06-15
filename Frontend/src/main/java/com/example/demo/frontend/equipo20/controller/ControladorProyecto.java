package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.ProyectoDTO;
import com.example.demo.frontend.equipo20.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("proyecto")
public class ControladorProyecto {

    @Autowired
    private IProyectoService servicio;

    // http://localhost:8081/proyecto/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<ProyectoDTO> Proyectos = servicio.findAllREST();
        model.addAttribute("proyectos", Proyectos);
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
        ProyectoDTO Proyecto = servicio.findByIdREST(id);
        model.addAttribute("proyecto", Proyecto);
        return "rest/form";
    }

    // http://localhost:8081/proyecto/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid ProyectoDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/proyecto";
    }

    // http://localhost:8081/proyecto/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/proyecto";
    }

}
