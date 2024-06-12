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

import com.horasExtras.rest.Backend_HorasExtras.dto.CargoDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.ICargoService;

@Controller
@RequestMapping("cargo")
public class ControladorCargo {

    @Autowired
    private ICargoService servicio;

    @ResponseBody
    @PostMapping("create")
    public CargoDTO agregarCargo(@Valid @NonNull @RequestBody CargoDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<CargoDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public CargoDTO findById(@PathVariable("id") int id) {
        Optional<CargoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent()) {
            CargoDTO dto = eDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteCargoById(@PathVariable("id") int id) {
        Optional<CargoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent()) {
            servicio.delete(eDto.get());
            return true;
        } else {
            return false;
        }
    }
}
