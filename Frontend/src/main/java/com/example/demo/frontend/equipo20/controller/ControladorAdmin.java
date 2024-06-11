package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.AdminDTO;
import com.example.demo.frontend.equipo20.service.IAdminService;
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
@RequestMapping("admin")
public class ControladorAdmin {
    
    @Autowired
    private IAdminService servicio;

    // http://localhost:8081/admin/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<AdminDTO> admins = servicio.findAllREST();
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
        AdminDTO admin = servicio.findByIdREST(id);
        model.addAttribute("admin", admin);
        return "rest/form";
    }

    // http://localhost:8081/admin/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid AdminDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/admin";
    }

    // http://localhost:8081/admin/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/admin";
    }
}
