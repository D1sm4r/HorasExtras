package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAdmin;
    @Column(name = "nombre_usuario")
    private String username;
    @Column(name = "password")
    private String password;

    //------------------------------------------------------------

    public AdminDTO toDTO() {
        AdminDTO dto = new AdminDTO();
        dto.setIdAdmin(this.getIdAdmin());
        dto.setUsername(this.getUsername());
        dto.setPassword(this.getPassword());
        return dto;
    }

}
