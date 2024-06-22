package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.IHorasExtrasService;

@Controller
@RequestMapping("horasextras")
public class HorasExtrasController {

    @Autowired
    private IHorasExtrasService servicio;

    @ResponseBody
    @PostMapping("create")
    public HorasExtrasDTO agregarHE(@Valid @NonNull @RequestBody HorasExtrasDTO dto) {

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
}
