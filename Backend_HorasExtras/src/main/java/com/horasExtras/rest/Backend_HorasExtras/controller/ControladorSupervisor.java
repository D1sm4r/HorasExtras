package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.ISupervisorService;

@Controller
@RequestMapping("supervisor")
public class ControladorSupervisor {

    @Autowired
    private ISupervisorService servicio;

    @ResponseBody
    @PostMapping("create")
    public SupervisorDTO agregarSupervisor(@Valid @NonNull @RequestBody SupervisorDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<SupervisorDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
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
    @PutMapping("update")
    public SupervisorDTO updateSupervisor(@Valid @NonNull @RequestBody SupervisorDTO dto) {
        Optional<SupervisorDTO> aDto = servicio.findById(dto.getIdSupervisor());
        if (aDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteSupervisorById(@PathVariable("id") int id) {
        Optional<SupervisorDTO> sDto = servicio.findById(id);
        if (sDto.isPresent() == true) {
            servicio.delete(sDto.get());
            return true;
        } else {
            return false;
        }
    }
}
