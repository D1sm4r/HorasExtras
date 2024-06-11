package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.NotificacionDTO;
import com.example.demo.frontend.equipo20.service.INotificacionService;
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
@RequestMapping("notificacion")
public class ControladorNotificacion {
    @Autowired
    private INotificacionService servicio;

    // http://localhost:8081/notificacion/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<NotificacionDTO> Notificacions = servicio.findAllREST();
        model.addAttribute("notificacions", Notificacions);
        return "rest/index";
    }

    // http://localhost:8081/notificacion/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("notificacion", new NotificacionDTO());
        return "rest/form";
    }

    // http://localhost:8081/notificacion/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        NotificacionDTO Notificacion = servicio.findByIdREST(id);
        model.addAttribute("notificacion", Notificacion);
        return "rest/form";
    }

    // http://localhost:8081/notificacion/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid NotificacionDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/notificacion";
    }

    // http://localhost:8081/notificacion/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/notificacion";
    }

}
