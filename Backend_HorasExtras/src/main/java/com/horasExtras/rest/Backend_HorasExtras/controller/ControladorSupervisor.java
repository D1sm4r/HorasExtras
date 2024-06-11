package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.ISupervisorService;

@Controller
@RequestMapping("supervisor")
public class ControladorSupervisor {

    @Autowired
    private ISupervisorService servicio;

    @ResponseBody
    @PostMapping("REST")
    public SupervisorDTO agregarSupervisor(@Valid @NonNull @RequestBody SupervisorDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("REST")
    public List<SupervisorDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("REST/{id}")
    public SupervisorDTO findById(@PathVariable("id") int id) {
        Optional<SupervisorDTO> sDto = servicio.findById(id);
        if (sDto.isPresent()) {
            SupervisorDTO dto = sDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("REST/{id}")
    public boolean deleteSupervisorById(@PathVariable("id") int id) {
        Optional<SupervisorDTO> sDto = servicio.findById(id);
        if (sDto.isPresent()) {
            servicio.delete(sDto.get());
            return true;
        } else {
            return false;
        }
    }
}
