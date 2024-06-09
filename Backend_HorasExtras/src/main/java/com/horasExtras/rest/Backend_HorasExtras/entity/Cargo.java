package com.horasExtras.rest.Backend_HorasExtras.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCargo;
    @Column(name = "nombre")
    private String name;
    @Column(name = "saldo")
    private String saldo;
}
