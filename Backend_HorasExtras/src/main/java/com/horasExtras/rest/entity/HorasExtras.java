package com.horasExtras.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HorasExtras")
public class HorasExtras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idHorasExtras;
    @Column
    private int cantidad;
    @Column
    private Date fecha;
    @Column
    private Date fecha_de_autorizacion;
    @Column
    private String justificacion;
    @Column
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "idSupervisor")
    private Supervisor supervisor;
}
