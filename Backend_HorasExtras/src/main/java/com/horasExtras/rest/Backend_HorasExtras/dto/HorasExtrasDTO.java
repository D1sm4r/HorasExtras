package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.HorasExtras;
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

    public HorasExtras toEntity(){
        HorasExtras e = new HorasExtras(idHorasExtras, cantidad, fecha, fecha_de_autorizacion
                ,justificacion, estado);
        e.setIdHorasExtras(this.getIdHorasExtras());
        e.setCantidad(this.getCantidad());
        e.setFecha(this.getFecha());
        e.setFecha_de_autorizacion(this.getFecha_de_autorizacion());
        e.setJustificacion(this.getJustificacion());
        e.setEstado(this.isEstado());

        if (this.empleado != null) {
            e.setEmpleado(this.empleado.toEntity());
        }

        if (this.proyecto != null) {
            e.setProyecto(this.proyecto.toEntity());
        }

        if(this.supervisor != null){
            e.setSupervisor(this.supervisor.toEntity());
        }

        return e;
    }

}
