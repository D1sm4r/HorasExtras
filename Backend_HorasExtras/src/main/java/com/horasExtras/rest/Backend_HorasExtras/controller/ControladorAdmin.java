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

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IAdminService;

@Controller
@RequestMapping("admin")
public class ControladorAdmin{

    @Autowired
    private IAdminService servicio;

    // http://localhost:8081/admin/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<AdminDTO> admins = servicio.findAll();
        model.addAttribute("admins", admins);
        return "rest/index";
    }

    // http://localhost:8081/admin/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("admin", new AdminDTO());
        return "rest/form";
    }

    // http://localhost:8081/admin/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<AdminDTO> adminOpt = servicio.findById(id);
        if (adminOpt.isPresent()) {
            model.addAttribute("admin", adminOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Admin no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/admin/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid AdminDTO a, Model model) {
        servicio.save(a);
        return "redirect:/admin/admin";
    }

    // http://localhost:8081/admin/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<AdminDTO> adminOpt = servicio.findById(id);
        if (adminOpt.isPresent()) {
            servicio.delete(adminOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/admin";
    }

}