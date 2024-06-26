package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;

import java.util.List;
import java.util.Optional;

public interface INotificacionService {

    public List<NotificacionDTO> findAll();

    public Optional<NotificacionDTO> findById(long id);

    public NotificacionDTO save(NotificacionDTO notificacion);

    public void delete(NotificacionDTO dto);

    List<NotificacionDTO> findByUserId(Long userId);
}
