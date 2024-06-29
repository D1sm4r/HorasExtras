package com.example.demo.frontend.equipo20.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HorasExtrasDTO {

    private long idHorasExtras;

    private int cantidad;

    private String fecha;

    private String fecha_de_autorizacion;

    private String justificacion;

    private boolean estado;

    //---------------------------------------------------------------

    private UserDTO user;

    private ProyectoDTO proyecto;

}
