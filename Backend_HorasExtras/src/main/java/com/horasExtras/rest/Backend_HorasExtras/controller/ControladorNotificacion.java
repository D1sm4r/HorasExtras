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

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.INotificacionService;

@Controller
@RequestMapping("notificacion")
public class ControladorNotificacion {

    @Autowired
    private INotificacionService servicio;

    @ResponseBody
    @PostMapping("create")
    public NotificacionDTO agregarNotificacion(@Valid @NonNull @RequestBody NotificacionDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<NotificacionDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public NotificacionDTO findById(@PathVariable("id") int id) {
        Optional<NotificacionDTO> nDto = servicio.findById(id);
        if (nDto.isPresent()) {
            NotificacionDTO dto = nDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteNotificacionById(@PathVariable("id") int id) {
        Optional<NotificacionDTO> nDto = servicio.findById(id);
        if (nDto.isPresent()) {
            servicio.delete(nDto.get());
            return true;
        } else {
            return false;
        }
    }
}