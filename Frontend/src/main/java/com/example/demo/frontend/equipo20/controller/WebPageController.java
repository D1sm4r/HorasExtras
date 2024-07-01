

package com.example.demo.frontend.equipo20.controller;

import com.example.demo.frontend.equipo20.dto.HorasExtrasDTO;
import com.example.demo.frontend.equipo20.service.IHorasExtrasService;
import com.example.demo.frontend.equipo20.service.INotificacionService;
import com.example.demo.frontend.equipo20.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("GestorHorasExtras")
public class WebPageController {

	@Autowired
	private IHorasExtrasService bdhs;

	@Autowired
	IProyectoService bdproyecto;

	@Autowired
	INotificacionService bdnotificacion;

	@GetMapping("")
	public String home(Model model) {
		return "WebPage/main";
	}


	//Logins de usuarios
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

	// Fin logins Usuarios
	@GetMapping("Empleado")
	public String Empleado(Model model) {
		model.addAttribute("hs",bdhs.findAllREST());
		return "Empleado/mantenedorEmpleado";
	}

	@GetMapping("hs")
	public String horasextrass(Model model) {
		model.addAttribute("hs", bdhs.findAllREST());
		return "rest/aaaa";
	}

	@GetMapping("hs/listar/nuevo/REST")
	public String crearHoras(Model model) {
		model.addAttribute("horasextras", new HorasExtrasDTO());
		return "rest/CrearHorasExtras";
	}


	@GetMapping("Admin")
	public String Admin(Model model) {
		model.addAttribute("hs",bdhs.findAllREST());
		//model.addAttribute("proyectos",bdproyecto.findAllREST());
		return "Admin/mantenedorAdmin";
	}

	@GetMapping("Supervisor")
	public String Supervisor(Model model) {
		model.addAttribute("hs",bdhs.findAllREST());
		return "Supervisor/mantenedorSupervisor";
	}

	@GetMapping("Supervisor/EditarHS/{id}")
	public String EditarHS(@PathVariable Long id, Model model) {
		model.addAttribute("horaextra", bdhs.findByIdREST(id));
		return "Supervisor/hs";
	}
	@GetMapping("Admin2")
	public String Admin2(Model model) {
		model.addAttribute("hs",bdhs.findAllREST());
		model.addAttribute("proyectos",bdproyecto.findAllREST());
		return "Admin/mantenedorAdmin2";
	}

	@GetMapping("Supervisor2")
	public String Supervisor2(Model model) {
		model.addAttribute("hs",bdhs.findAllREST());
		model.addAttribute("proyectos",bdproyecto.findAllREST());
		return "Supervisor/mantenedorSupervisor2";
	}






}
