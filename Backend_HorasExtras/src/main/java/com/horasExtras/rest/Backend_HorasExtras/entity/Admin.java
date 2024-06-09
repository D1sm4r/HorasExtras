package com.horasExtras.rest.Backend_HorasExtras.entity;

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
    @Column(name = "contraseña")
    private String contraseña;
}
