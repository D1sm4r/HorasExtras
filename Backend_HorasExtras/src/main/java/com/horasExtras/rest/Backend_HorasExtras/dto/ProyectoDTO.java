package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

    private Long idProyecto;

    private String name;

    //------------------------------------------------------------

    public Proyecto toEntity(){

        Proyecto e = new Proyecto(idProyecto, name);
        e.setIdProyecto(this.getIdProyecto());
        e.setName(this.getName());
        return e;
    }
}
