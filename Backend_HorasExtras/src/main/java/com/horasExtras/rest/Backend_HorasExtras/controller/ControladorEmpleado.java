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

import com.horasExtras.rest.Backend_HorasExtras.dto.EmpleadoDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IEmpleadoService;

@Controller
@RequestMapping("empleado")
public class ControladorEmpleado {

    @Autowired
    private IEmpleadoService servicio;

    // http://localhost:8081/empleado/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<EmpleadoDTO> empleados = servicio.findAll();
        model.addAttribute("empleados", empleados);
        return "rest/index";
    }

    // http://localhost:8081/empleado/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("empleado", new EmpleadoDTO());
        return "rest/form";
    }

    // http://localhost:8081/empleado/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<EmpleadoDTO> empleadoOpt = servicio.findById(id);
        if (empleadoOpt.isPresent()) {
            model.addAttribute("empleado", empleadoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Empleado no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/empleado/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid EmpleadoDTO e, Model model) {
        servicio.save(e);
        return "redirect:/admin/empleado";
    }

    // http://localhost:8081/empleado/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<EmpleadoDTO> empleadoOpt = servicio.findById(id);
        if (empleadoOpt.isPresent()) {
            servicio.delete(empleadoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/empleado";
    }

}