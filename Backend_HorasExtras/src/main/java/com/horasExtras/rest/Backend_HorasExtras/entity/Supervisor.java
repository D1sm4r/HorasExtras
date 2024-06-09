package com.horasExtras.rest.Backend_HorasExtras.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Supervisor")
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSupervisor;
    @Column(name = "nombre_ususario")
    private String username;
    @Column(name = "contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;
}
