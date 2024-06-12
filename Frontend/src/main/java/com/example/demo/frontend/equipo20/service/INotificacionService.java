package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.NotificacionDTO;

import java.util.List;

public interface INotificacionService {

    public List<NotificacionDTO> findAllREST();

    public NotificacionDTO findByIdREST(Long id);

    public NotificacionDTO saveREST(NotificacionDTO notificacion);

    public NotificacionDTO deleteREST(Long id);
}
