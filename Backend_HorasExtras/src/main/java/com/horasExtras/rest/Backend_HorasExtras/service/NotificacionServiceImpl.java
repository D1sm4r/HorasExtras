package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Notificacion;
import com.horasExtras.rest.Backend_HorasExtras.entity.UserEntity;
import com.horasExtras.rest.Backend_HorasExtras.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class NotificacionServiceImpl implements INotificacionService {

    @Autowired
    private NotificacionRepository beta;

    @Override
    public List<NotificacionDTO> findAll() {
        List<Notificacion> listE = (List<Notificacion>) beta.findAll();
        List<NotificacionDTO> listDto = new ArrayList<NotificacionDTO>();
        for (Notificacion e : listE) {
            NotificacionDTO NotificacionDTO = e.toDTO();

            UserEntity UserEntity = e.getUser();
            if (UserEntity != null) {
                NotificacionDTO.setUser(UserEntity.toDTO());
            }

            listDto.add(NotificacionDTO);
        }
        return listDto;
    }

    @Override
    public Optional<NotificacionDTO> findById(long id) {
        Optional<Notificacion> oe = beta.findById(id);
        Notificacion e = oe.get();
        NotificacionDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public NotificacionDTO save(NotificacionDTO notificacion) {
        Notificacion e = beta.save(notificacion.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(NotificacionDTO B) {
        beta.delete(B.toEntity());
    }
}
