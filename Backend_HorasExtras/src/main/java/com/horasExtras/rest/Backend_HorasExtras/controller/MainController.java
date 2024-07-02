package com.horasExtras.rest.Backend_HorasExtras.controller;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IHorasExtrasService;
import com.horasExtras.rest.Backend_HorasExtras.service.INotificacionService;
import com.horasExtras.rest.Backend_HorasExtras.service.IProyectoService;
import com.horasExtras.rest.Backend_HorasExtras.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("GestorHorasExtras")
public class MainController {

    @Autowired
    IHorasExtrasService bdhs;

    @Autowired
    INotificacionService bdnotificaciones;

    @Autowired
    IProyectoService bdproyecto;

    @Autowired
    IUserService bduser;


    @GetMapping("index")
    public String home() {
        return "Main/main";
    }


    //Logins de usuarios
    @GetMapping("loginEmpleado")
    public String loginEmpleado() {
        return "Main/loginEmpleado";
    }

    @GetMapping("loginAdmin")
    public String loginAdmin() {
        return "Main/loginAdmin";
    }

    @GetMapping("loginSupervisor")
    public String loginSupervisor() {
        return "Main/loginSupervisor";
    }


    // MAPEO DE PAGINAS DE ADMIN
    @GetMapping("admin_usuarios")
    public String admin_usuarios(Model model) {
        List<HorasExtrasDTO> hs = bdhs.findAll();
        HorasExtrasDTO horasExtrasDTO = new HorasExtrasDTO();
        model.addAttribute("horaextra",horasExtrasDTO);
        model.addAttribute("hs", hs);
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("notificaciones",bdnotificaciones.findAll());
        return "Admin/usuarios";
    }

    @GetMapping("admin_proyectos")
    public String admin_proyectos(Model model) {
        List<HorasExtrasDTO> hs = bdhs.findAll();
        HorasExtrasDTO horasExtrasDTO = new HorasExtrasDTO();
        model.addAttribute("horaextra",horasExtrasDTO);
        model.addAttribute("hs", hs);
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("notificaciones",bdnotificaciones.findAll());
        return "Admin/proyectos";
    }

    // MAPEO DE PAGINAS DE EMPLEADO

    @GetMapping("empleado")
    public String empleado(Model model) {
        List<HorasExtrasDTO> hs = bdhs.findAll();
        HorasExtrasDTO horasExtrasDTO = new HorasExtrasDTO();
        model.addAttribute("horaextra",horasExtrasDTO);
        model.addAttribute("hs", hs);
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("notificaciones",bdnotificaciones.findAll());
        return "Empleado/usuarios";
    }

    @GetMapping("solicitar")
    public String solicitarHoraExtra(Model model) {
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("horaextra", new HorasExtrasDTO());
        return "Empleado/solicitar";
    }

    // MAPEO DE PAGINAS DE SUPERVISOR

    @GetMapping("supervisor")
    public String supervisor(Model model) {
        List<HorasExtrasDTO> hs = bdhs.findAll();
        HorasExtrasDTO horasExtrasDTO = new HorasExtrasDTO();
        model.addAttribute("horaextra",horasExtrasDTO);
        model.addAttribute("hs", hs);
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("notificaciones",bdnotificaciones.findAll());
        return "Supervisor/usuarios";
    }

    @GetMapping("aprobar/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<HorasExtrasDTO> horaextra = bdhs.findById(id);
        model.addAttribute("horaextra", horaextra);
        model.addAttribute("proyectos", bdproyecto.findAll());
        model.addAttribute("usuarios", bduser.findAll());
        return "Supervisor/aprobar";
    }
}
