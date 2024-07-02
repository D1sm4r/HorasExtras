package com.horasExtras.rest.Backend_HorasExtras.dto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.horasExtras.rest.Backend_HorasExtras.service.INotificacionService;
import com.horasExtras.rest.Backend_HorasExtras.service.IProyectoService;
import com.horasExtras.rest.Backend_HorasExtras.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IHorasExtrasService;

@Controller
@RequestMapping("horasextras")
public class HorasExtrasController {

    @Autowired
    private IHorasExtrasService servicio;

    @Autowired
    private IProyectoService bdproyecto;

    @Autowired
    private IUserService bduser;

    @Autowired
    private INotificacionService bdnotificaciones;

    @PostMapping("solicitar")
    public ResponseEntity<HorasExtrasDTO> solicitarHorasExtras(@RequestBody HorasExtrasDTO horasExtrasDTO) {
        HorasExtrasDTO result = servicio.solicitarHorasExtras(horasExtrasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ResponseBody
    @PostMapping("create")
    public HorasExtrasDTO agregarHE(@ModelAttribute HorasExtrasDTO dto) {
        return servicio.save(dto);
    }


    @ResponseBody
    @GetMapping("findall")
    public List<HorasExtrasDTO> findAll() {

        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public HorasExtrasDTO findById(@PathVariable("id") int id) {
        Optional<HorasExtrasDTO> heDto = servicio.findById(id);
        if (heDto.isPresent()) {
            HorasExtrasDTO dto = heDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public HorasExtrasDTO updateHorasExtras(@Valid @NonNull @RequestBody HorasExtrasDTO dto) {
        Optional<HorasExtrasDTO> oDto = servicio.findById(dto.getIdHorasExtras());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteHEById(@PathVariable("id") int id) {
        Optional<HorasExtrasDTO> oDto = servicio.findById(id);
        if (oDto.isPresent() == true) {
            servicio.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // FRONTEND ///////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    @GetMapping("listar/REST")
    public String listarREST(Model model) {
        List<HorasExtrasDTO> hs = servicio.findAll();
        HorasExtrasDTO horasExtrasDTO = new HorasExtrasDTO();
        model.addAttribute("horaextra",horasExtrasDTO);
        model.addAttribute("hs", hs);
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("notificaciones",bdnotificaciones.findAll());
        return "rest/index";
    }

    // http://localhost:8081/horaextras/listar/nuevo/REST
    @GetMapping("listar/nuevo/REST")
    public String agregarREST(Model model) {
        model.addAttribute("usuarios",bduser.findAll());
        model.addAttribute("proyectos",bdproyecto.findAll());
        model.addAttribute("horaextra", new HorasExtrasDTO());
        return "rest/form";
    }

    // http://localhost:8081/horaextras/REST/id
    @GetMapping("editar/REST/{id}")
    public String editarREST(@PathVariable long id, Model model) {
        Optional<HorasExtrasDTO> horaextra = servicio.findById(id);
        model.addAttribute("horaextra", horaextra);
        model.addAttribute("proyectos", bdproyecto.findAll());
        model.addAttribute("usuarios", bduser.findAll());
        return "rest/form";
    }

}
