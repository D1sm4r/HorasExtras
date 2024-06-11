package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
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

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "horasEmpleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "horasProyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "horasSupervisor")
    private Supervisor supervisor;

    //------------------------------------------------------------

    public HorasExtras(@JsonProperty("idHorasExtras")long idHorasExtras, @JsonProperty("cantidad")int cantidad,
                       @JsonProperty("fecha")Date fecha, @JsonProperty("fecha_de_autorizacion")Date fecha_de_autorizacion,
                       @JsonProperty("justificacion") String justificacion, @JsonProperty("estado")boolean estado){
        super();
        this.idHorasExtras = idHorasExtras;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fecha_de_autorizacion = fecha_de_autorizacion;
        this.justificacion = justificacion;
        this.estado = estado;
    }

    public HorasExtrasDTO toDTO(){
        HorasExtrasDTO dto = new HorasExtrasDTO();
        dto.setIdHorasExtras(this.getIdHorasExtras());
        dto.setCantidad(this.getCantidad());
        dto.setFecha(this.getFecha());
        dto.setFecha_de_autorizacion(this.getFecha_de_autorizacion());
        dto.setJustificacion(this.getJustificacion());
        dto.setEstado(this.isEstado());

        if (this.empleado!= null) {
            dto.setEmpleado(this.empleado.toDTO());
        }

        if(this.proyecto != null){
            dto.setProyecto(this.proyecto.toDTO());
        }

        if(this.supervisor != null){
            dto.setSupervisor(this.supervisor.toDTO());
        }

        return dto;
    }
}
