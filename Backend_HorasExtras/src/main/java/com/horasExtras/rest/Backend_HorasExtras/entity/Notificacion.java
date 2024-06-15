package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horasExtras.rest.Backend_HorasExtras.dto.NotificacionDTO;
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

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idSupervisor")
    private Supervisor supervisor;

    //------------------------------------------------------------

    public Notificacion(@JsonProperty("idNotificacion")long idNotificacion, @JsonProperty("mensaje")String mensaje){
        super();
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
    }

    public NotificacionDTO toDTO(){

        NotificacionDTO dto = new NotificacionDTO();
        dto.setIdNotificacion(this.getIdNotificacion());
        dto.setMensaje(this.getMensaje());

        if(this.supervisor != null) {
            dto.setSupervisor(this.supervisor.toDTO());
        }

        if(this.empleado != null) {
            dto.setEmpleado(this.empleado.toDTO());
        }

        return dto;
    }

}
