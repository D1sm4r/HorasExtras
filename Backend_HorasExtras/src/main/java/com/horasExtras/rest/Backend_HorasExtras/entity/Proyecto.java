package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.horasExtras.rest.Backend_HorasExtras.dto.ProyectoDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProyecto;
    @Column(name = "nombre")
    private String name;

    //------------------------------------------------------------

    public ProyectoDTO toDTO() {
        ProyectoDTO dto = new ProyectoDTO();
        dto.setIdProyecto(this.getIdProyecto());
        dto.setName(this.getName());
        return dto;
    }

}
