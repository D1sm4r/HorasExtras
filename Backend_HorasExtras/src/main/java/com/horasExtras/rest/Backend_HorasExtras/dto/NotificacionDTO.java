package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Notificacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDTO {

    private long idNotificacion;

    private String mensaje;

    //------------------------------------------------------------

    private EmpleadoDTO empleado;

    private SupervisorDTO supervisor;

    //------------------------------------------------------------

    public Notificacion toEntity(){

        Notificacion e = new Notificacion();
        e.setIdNotificacion(this.getIdNotificacion());
        e.setMensaje(this.getMensaje());

        if(this.supervisor != null) {
            e.setSupervisor(this.supervisor.toEntity());
        }

        if(this.empleado != null) {
            e.setEmpleado(this.empleado.toEntity());
        }

        return e;
    }

}
