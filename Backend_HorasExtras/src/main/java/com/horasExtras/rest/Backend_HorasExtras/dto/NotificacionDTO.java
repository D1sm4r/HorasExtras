package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Notificacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDTO {

    private Long idNotificacion;

    private String mensaje;

    //------------------------------------------------------------

    private UserDTO user;

    //------------------------------------------------------------

    public Notificacion toEntity(){

        Notificacion e = new Notificacion();
        e.setIdNotificacion(this.getIdNotificacion());
        e.setMensaje(this.getMensaje());

        if(this.user != null) {
            e.setUser(this.user.toEntity());
        }

        return e;
    }

}
