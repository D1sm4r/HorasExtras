package com.horasExtras.rest.Backend_HorasExtras.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNotificacion;
    @Column
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idSupervisor")
    private Supervisor supervisor;
}
