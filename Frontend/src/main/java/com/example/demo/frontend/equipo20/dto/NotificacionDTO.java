package com.example.demo.frontend.equipo20.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificacionDTO {

    private long idNotificacion;

    private String mensaje;

    //------------------------------------------------------------

    private UserDTO user;

    //------------------------------------------------------------


}
