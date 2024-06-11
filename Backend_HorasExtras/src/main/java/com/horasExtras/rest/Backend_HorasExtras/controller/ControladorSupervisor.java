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

import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.ISupervisorService;

@Controller
@RequestMapping("supervisor")
public class ControladorSupervisor {

    @Autowired
    private ISupervisorService servicio;

    // http://localhost:8081/supervisor/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<SupervisorDTO> supervisores = servicio.findAll();
        model.addAttribute("supervisores", supervisores);
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
        Optional<SupervisorDTO> supervisorOpt = servicio.findById(id);
        if (supervisorOpt.isPresent()) {
            model.addAttribute("supervisor", supervisorOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Supervisor no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/supervisor/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid SupervisorDTO s, Model model) {
        servicio.save(s);
        return "redirect:/admin/supervisor";
    }

    // http://localhost:8081/supervisor/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<SupervisorDTO> supervisorOpt = servicio.findById(id);
        if (supervisorOpt.isPresent()) {
            servicio.delete(supervisorOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/supervisor";
    }

}
