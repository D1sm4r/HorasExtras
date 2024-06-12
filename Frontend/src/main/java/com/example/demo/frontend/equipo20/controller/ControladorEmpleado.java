package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;
import com.example.demo.frontend.equipo20.service.IEmpleadoService;
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
@RequestMapping("empleado")
public class ControladorEmpleado {

    @Autowired
    private IEmpleadoService servicio;

    // http://localhost:8081/empleado/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<EmpleadoDTO> empleados = servicio.findAllREST();
        model.addAttribute("empleados", empleados);
        return "AdminPage/mantenedor_empleado";
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
        EmpleadoDTO empleado = servicio.findByIdREST(id);
        model.addAttribute("empleado", empleado);
        return "rest/form";
    }

    // http://localhost:8081/empleado/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid EmpleadoDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/empleado";
    }

    // http://localhost:8081/empleado/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/empleado";
    }
    
    
}
