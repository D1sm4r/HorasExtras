package com.horasExtras.rest.Backend_HorasExtras.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
import com.horasExtras.rest.Backend_HorasExtras.service.INotificacionService;

@Controller
@RequestMapping("notificacion")
public class NotificacionController {

    @Autowired
    private INotificacionService servicio;

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<NotificacionDTO>> getNotificacionesByUserId(@PathVariable Long userId) {
        List<NotificacionDTO> notificaciones = servicio.findByUserId(userId);
        return ResponseEntity.ok(notificaciones);
    }

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
    @PutMapping("update")
    public NotificacionDTO updateNotificacion(@Valid @NonNull @RequestBody NotificacionDTO dto) {
        Optional<NotificacionDTO> oDto = servicio.findById(dto.getIdNotificacion());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteNotificacionById(@PathVariable("id") int id) {
        Optional<NotificacionDTO> nDto = servicio.findById(id);
        if (nDto.isPresent() == true) {
            servicio.delete(nDto.get());
            return true;
        } else {
            return false;
        }
    }
}