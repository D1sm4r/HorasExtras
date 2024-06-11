package com.example.demo.frontend.equipo20.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;
import com.example.demo.frontend.equipo20.service.IPersonaService;

@Controller
@RequestMapping("persona")
public class ControladorPersona {

	@Autowired
	private IPersonaService servicio;

	// http://localhost:8081/persona/listar/REST
	@GetMapping("listar/REST")
	public String listarREST(Model model) {
		List<PersonaDTO> personas = servicio.findAllREST();
		model.addAttribute("personas", personas);
		return "rest/index";
	}

	// http://localhost:8081/persona/listar/nuevo/REST
	@GetMapping("listar/nuevo/REST")
	public String agregarREST(Model model) {
		model.addAttribute("persona", new PersonaDTO());
		return "rest/form";
	}

	// http://localhost:8081/persona/REST/id
	@GetMapping("editar/REST/{id}")
	public String editarREST(@PathVariable long id, Model model) {
		PersonaDTO persona = servicio.findByIdREST(id);
		model.addAttribute("persona", persona);
		return "rest/form";
	}

	// http://localhost:8081/persona/grabar/REST
	@PostMapping("grabar/REST")
	public String saveREST(@Valid PersonaDTO p, Model model) {
	    servicio.saveREST(p);
	    return "redirect:/admin/persona";
	}

	// http://localhost:8081/persona/eliminar/id
	@GetMapping("eliminar/REST/{id}")
	public String deleteREST(@PathVariable long id, Model model) {
		servicio.deleteREST(id);
		return "redirect:/admin/persona";
	}

}
