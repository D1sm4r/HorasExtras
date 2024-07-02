package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.HorasExtras;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorasExtrasDTO {

    private Long idHorasExtras;

    private int cantidad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_de_autorizacion;

    private String justificacion;

    private String estado;

    private UserDTO user;

    private ProyectoDTO proyecto;

    public HorasExtras toEntity(){
        HorasExtras e = new HorasExtras();
        if (this.idHorasExtras != null) {
            e.setIdHorasExtras(this.idHorasExtras);
        }
        e.setCantidad(this.getCantidad());
        e.setFecha(this.getFecha());
        e.setFecha_de_autorizacion(this.getFecha_de_autorizacion());
        e.setJustificacion(this.getJustificacion());
        e.setEstado(this.estado);

        if (this.proyecto != null) {
            e.setProyecto(this.proyecto.toEntity());
        }

        if(this.user != null){
            e.setUser(this.user.toEntity());
        }

        return e;
    }
}
