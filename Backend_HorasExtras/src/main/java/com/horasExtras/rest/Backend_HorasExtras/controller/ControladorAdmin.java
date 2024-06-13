package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IAdminService;

@Controller
@RequestMapping("admin")
public class ControladorAdmin {

    @Autowired
    private IAdminService servicio;

    @ResponseBody
    @PostMapping("create")
    public AdminDTO agregarAdmin(@Valid @NonNull @RequestBody AdminDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<AdminDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
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
    @PutMapping("update")
    public AdminDTO updateAdmin(@Valid @NonNull @RequestBody AdminDTO dto) {
        Optional<AdminDTO> oDto = servicio.findById(dto.getIdAdmin());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{idAdmin}")
    public boolean deleteAdminById(@PathVariable("idAdmin") int idAdmin) {
        Optional<AdminDTO> aDto = servicio.findById(idAdmin);
        if (aDto.isPresent() == true) {
            servicio.delete(aDto.get());
            return true;
        } else {
            return false;
        }
    }
}