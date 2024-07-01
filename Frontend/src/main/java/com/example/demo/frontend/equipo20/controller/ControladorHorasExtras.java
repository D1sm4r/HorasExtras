package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.HorasExtrasDTO;
import com.example.demo.frontend.equipo20.service.IHorasExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("hs")
public class ControladorHorasExtras {
    @Autowired
    private IHorasExtrasService servicio;

    // http://localhost:8081/horasextras/listar/REST
    @GetMapping("/listar/REST")
    public String listarREST(Model model) {
        List<HorasExtrasDTO> HorasExtrass = servicio.findAllREST();
        model.addAttribute("horasextrass", HorasExtrass);
        return "rest/aaaa";
    }

    // http://localhost:8081/horasextras/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("horasextras", new HorasExtrasDTO());
        return "rest/CrearHorasExtras";
    }

    // http://localhost:8081/horasextras/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        HorasExtrasDTO HorasExtras = servicio.findByIdREST(id);
        model.addAttribute("horasextras", HorasExtras);
        return "rest/ActualizarHorasExtras";
    }

    // http://localhost:8081/horasextras/grabar/REST
    @PostMapping("grabar/REST")
    public String saveREST(@Valid HorasExtrasDTO p, Model model) {
        servicio.saveREST(p);
        return "redirect:/GestorHorasExtras/Empleado";
    }

    // http://localhost:8081/horasextras/eliminar/id
    @GetMapping("eliminar/REST/{id}")
    public String deleteREST(@PathVariable long id, Model model) {
        servicio.deleteREST(id);
        return "redirect:/admin/horasextras";
    }

    // http://localhost:8081/horasextras/grabar/REST
    @PostMapping("grabar2/REST")
    public ResponseEntity<String> saveREST2(@Valid @RequestBody HorasExtrasDTO p) {
        try {
            servicio.saveREST(p);
            return ResponseEntity.ok("Horas Extras guardadas con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar Horas Extras");
        }
    }

}