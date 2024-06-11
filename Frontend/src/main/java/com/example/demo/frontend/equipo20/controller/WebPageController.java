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
@RequestMapping("webpage")
public class WebPageController {
	
	// http://localhost:8081/persona/listar/REST
		@GetMapping("login")
		public String login() {
			return "/WebPage/login";
		}
		
	// http://localhost:8081/persona/listar/REST
		@GetMapping("register")
		public String register() {
			return "/WebPage/register";
		}
		
		
		@GetMapping("home")
		public String home(Model model) {
			return "AdminPage/starter";
		}
		


}
