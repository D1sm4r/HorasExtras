package com.example.demo.frontend.equipo20.dto;

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


}
