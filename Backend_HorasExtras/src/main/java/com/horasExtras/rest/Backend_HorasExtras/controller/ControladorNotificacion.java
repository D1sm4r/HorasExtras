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

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.INotificacionService;

@Controller
@RequestMapping("notificacion")
public class ControladorNotificacion {

    @Autowired
    private INotificacionService servicio;

    // http://localhost:8081/notificacion/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<NotificacionDTO> notificaciones = servicio.findAll();
        model.addAttribute("notificaciones", notificaciones);
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
        Optional<NotificacionDTO> notificacionOpt = servicio.findById(id);
        if (notificacionOpt.isPresent()) {
            model.addAttribute("notificacion", notificacionOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Notificacion no encontrada");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/notificacion/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid NotificacionDTO n, Model model) {
        servicio.save(n);
        return "redirect:/admin/notificacion";
    }

    // http://localhost:8081/notificacion/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<NotificacionDTO> notificacionOpt = servicio.findById(id);
        if (notificacionOpt.isPresent()) {
            servicio.delete(notificacionOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/notificacion";
    }

}