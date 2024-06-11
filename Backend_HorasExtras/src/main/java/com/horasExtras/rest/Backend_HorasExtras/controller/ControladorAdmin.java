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

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IAdminService;

@Controller
@RequestMapping("admin")
public class ControladorAdmin {

    @Autowired
    private IAdminService servicio;

    @ResponseBody
    @PostMapping("REST")
    public AdminDTO agregarAdmin(@Valid @NonNull @RequestBody AdminDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("REST")
    public List<AdminDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("REST/{id}")
    public AdminDTO findById(@PathVariable("id") int id) {
        Optional<AdminDTO> aDto = servicio.findById(id);
        if (aDto.isPresent()) {
            AdminDTO dto = aDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("REST/{id}")
    public boolean deleteAdminById(@PathVariable("id") int id) {
        Optional<AdminDTO> aDto = servicio.findById(id);
        if (aDto.isPresent()) {
            servicio.delete(aDto.get());
            return true;
        } else {
            return false;
        }
    }
}