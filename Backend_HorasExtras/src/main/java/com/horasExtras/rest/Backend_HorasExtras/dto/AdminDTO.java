package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private long idAdmin;

    private String username;

    private String password;

    //------------------------------------------------------------

    public Admin toEntity(){
        Admin e = new Admin(idAdmin, username, password);
        e.setIdAdmin(this.getIdAdmin());
        e.setUsername(this.getUsername());
        e.setPassword(this.getPassword());
        return e;
    }
}
