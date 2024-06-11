package com.example.demo.frontend.equipo20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorasExtrasDTO {

    private long idHorasExtras;

    private int cantidad;

    private Date fecha;

    private Date fecha_de_autorizacion;

    private String justificacion;

    private boolean estado;

    //---------------------------------------------------------------

    private EmpleadoDTO empleado;

    private ProyectoDTO proyecto;

    private SupervisorDTO supervisor;

    //---------------------------------------------------------------


}
