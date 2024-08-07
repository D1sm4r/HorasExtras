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
    private Long idNotificacion;
    @Column
    private String mensaje;

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity user;

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

        if(this.user != null) {
            dto.setUser(this.user.toDTO());
        }

        return dto;
    }

}
