package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
import com.horasExtras.rest.Backend_HorasExtras.dto.ProyectoDTO;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    public List<ProyectoDTO> findAll();

    public Optional<ProyectoDTO> findById(long id);

    public ProyectoDTO save(ProyectoDTO proyecto);

    public void delete(ProyectoDTO dto);
}
