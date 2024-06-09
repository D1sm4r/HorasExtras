package com.horasExtras.rest.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre_usuario")
    private String username;
    @Column(name = "contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "idCargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;
}
