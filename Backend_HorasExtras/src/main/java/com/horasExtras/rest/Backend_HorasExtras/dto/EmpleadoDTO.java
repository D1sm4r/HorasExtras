package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private long id;

    private String username;

    private String contraseña;

    //------------------------------------------------------------

    private CargoDTO cargo;

    private AdminDTO admin;

    //------------------------------------------------------------

    public Empleado toEntity(){
        Empleado e = new Empleado(id, username, contraseña);
        e.setId(this.getId());
        e.setUsername(this.getUsername());
        e.setContraseña(this.getContraseña());

        if(this.cargo != null) {
            e.setCargo(this.cargo.toEntity());
        }
        if(this.admin != null) {
            e.setAdmin(this.admin.toEntity());
        }
        return e;
    }
}
