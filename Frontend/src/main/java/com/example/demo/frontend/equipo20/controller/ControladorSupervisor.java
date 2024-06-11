package com.example.demo.frontend.equipo20.controller;


import com.example.demo.frontend.equipo20.dto.SupervisorDTO;
import com.example.demo.frontend.equipo20.service.ISupervisorService;
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
@RequestMapping("supervisor")
public class ControladorSupervisor {

    @Autowired
    private ISupervisorService servicio;

    // http://localhost:8081/supervisor/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<SupervisorDTO> Supervisors = servicio.findAllREST();
        model.addAttribute("supervisors", Supervisors);
        return "rest/index";
    }

    // http://localhost:8081/supervisor/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("supervisor", new SupervisorDTO());
        return "rest/form";
    }

    // http://localhost:8081/supervisor/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        SupervisorDTO Supervisor = servicio.findByIdREST(id);
        model.addAttribute("supervisor", Supervisor);
        return "rest/form";
    }

    // http://localhost:8081/supervisor/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid SupervisorDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/supervisor";
    }

    // http://localhost:8081/Supervisor/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/supervisor";
    }

}
