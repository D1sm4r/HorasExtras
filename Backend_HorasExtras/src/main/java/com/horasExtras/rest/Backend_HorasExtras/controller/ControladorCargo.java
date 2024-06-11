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

import com.horasExtras.rest.Backend_HorasExtras.dto.CargoDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.ICargoService;

@Controller
@RequestMapping("cargo")
public class ControladorCargo {

    @Autowired
    private ICargoService servicio;

    // http://localhost:8081/cargo/listar/REST
    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<CargoDTO> cargos = servicio.findAll();
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
        Optional<CargoDTO> cargoOpt = servicio.findById(id);
        if (cargoOpt.isPresent()) {
            model.addAttribute("cargo", cargoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, redirigiendo a una página de error o agregando un mensaje.
            model.addAttribute("mensaje", "Cargo no encontrado");
            return "rest/error"; // Asegúrate de tener una vista 'error' o ajusta según tu estructura.
        }
        return "rest/form";
    }

    // http://localhost:8081/cargo/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid CargoDTO c, Model model) {
        servicio.save(c);
        return "redirect:/admin/cargo";
    }

    // http://localhost:8081/cargo/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        Optional<CargoDTO> cargoOpt = servicio.findById(id);
        if (cargoOpt.isPresent()) {
            servicio.delete(cargoOpt.get());
        } else {
            // Manejar el caso cuando el supervisor no se encuentra, por ejemplo, añadiendo un mensaje de error.
            return "redirect:/admin/error"; // Asegúrate de tener una ruta de error o ajusta según tu estructura.
        }
        return "redirect:/admin/cargo";
    }

}
