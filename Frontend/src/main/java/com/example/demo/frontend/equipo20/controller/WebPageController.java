package com.example.demo.frontend.equipo20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("webpage")
public class WebPageController {

	@GetMapping("main")
	public String home(Model model) {
		return "WebPage/main";
	}

	@GetMapping("loginEmpleado")
	public String loginEmpleado() {
		return "Empleado/loginEmpleado";
	}

	@GetMapping("loginAdmin")
	public String loginAdmin() {
		return "Admin/loginAdmin";
	}

	@GetMapping("loginSupervisor")
	public String loginSupervisor() {
		return "Supervisor/loginSupervisor";
	}

	@GetMapping("register")
	public String register() {
		return "/WebPage/register";
	}
}
