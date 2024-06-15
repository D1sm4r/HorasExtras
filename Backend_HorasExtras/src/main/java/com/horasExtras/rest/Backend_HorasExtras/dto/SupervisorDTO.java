package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorDTO {

    private long idSupervisor;

    private String username;

    private String password;

    //------------------------------------------------------------

    private AdminDTO admin;

    //------------------------------------------------------------

    public Supervisor toEntity() {

        Supervisor e = new Supervisor(idSupervisor, username, password);
        e.setIdSupervisor(this.getIdSupervisor());
        e.setUsername(this.getUsername());
        e.setPassword(this.getPassword());

        if (this.admin != null) {
            e.setAdmin(this.admin.toEntity());
        }

        return e;
    }

}
