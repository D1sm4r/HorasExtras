package com.example.demo.frontend.equipo20.controller;


import java.util.ArrayList;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;
import com.example.demo.frontend.equipo20.service.IPersonaService;

@Controller
@RequestMapping("Main")
public class AdminPageController {
	
	@Autowired
	private IPersonaService bdpersona;

	
	@GetMapping("home")
	public String home(Model model) {
		return "AdminPage/starter";
	}
	
	///// PERSONA INICIO
	// http://localhost:7777/admin/persona
	@GetMapping("persona")
	public String persona(Model model) {
		List<PersonaDTO> personas = bdpersona.findAllREST();
		model.addAttribute("persona", new PersonaDTO());
		model.addAttribute("personas", personas);
		return "AdminPage/mantenedor_persona";
	}

	// http://localhost:7777/admin/editar/persona/(id}
	@GetMapping("editar/persona/{id}")
	public String editarpersona(@PathVariable Long id,Model model) {
		PersonaDTO persona = bdpersona.findByIdREST(id);
		model.addAttribute("persona", persona);
		return "AdminPage/editar_persona";
	}

	// http://localhost:7777/admin/eliminar/persona/(id}
	@GetMapping("eliminar/persona/{id}")
	public String deletepersona(@PathVariable Long id, Model model) {
		bdpersona.deleteREST(id);
		return "redirect:/admin/persona";
	}

	///// PERSONA FIN

}
