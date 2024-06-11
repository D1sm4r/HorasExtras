package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.CargoDTO;
import com.example.demo.frontend.equipo20.service.ICargoService;
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
@RequestMapping("cargo")
public class ControladorCargo {

    @Autowired
    private ICargoService servicio;

    // http://localhost:8081/cargo/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<CargoDTO> cargos = servicio.findAllREST();
        model.addAttribute("cargos", cargos);
        return "rest/index";
    }

    // http://localhost:8081/cargo/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("cargo", new CargoDTO());
        return "rest/form";
    }

    // http://localhost:8081/cargo/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        CargoDTO cargo = servicio.findByIdREST(id);
        model.addAttribute("cargo", cargo);
        return "rest/form";
    }

    // http://localhost:8081/cargo/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid CargoDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/admin/cargo";
    }

    // http://localhost:8081/cargo/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/cargo";
    }
}
