package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.EmpleadoDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IEmpleadoService;

@Controller
@RequestMapping("empleado")
public class ControladorEmpleado {

    @Autowired
    private IEmpleadoService servicio;

    @ResponseBody
    @PostMapping("create")
    public EmpleadoDTO agregarEmpleado(@Valid @NonNull @RequestBody EmpleadoDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<EmpleadoDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public EmpleadoDTO findById(@PathVariable("id") int id) {
        Optional<EmpleadoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent()) {
            EmpleadoDTO dto = eDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public EmpleadoDTO updateEmpleado(@Valid @NonNull @RequestBody EmpleadoDTO dto) {
        Optional<EmpleadoDTO> eDto = servicio.findById(dto.getId());
        if (eDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteEmpleadoById(@PathVariable("id") int id) {
        Optional<EmpleadoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent() == true) {
            servicio.delete(eDto.get());
            return true;
        } else {
            return false;
        }
    }
}