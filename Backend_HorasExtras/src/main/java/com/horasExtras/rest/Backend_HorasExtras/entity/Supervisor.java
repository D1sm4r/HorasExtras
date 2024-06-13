package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;
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
    @Column(name = "password")
    private String password;

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

    //------------------------------------------------------------

    public Supervisor(@JsonProperty("idSupervisor")long idSupervisor, @JsonProperty("username")String username,
                      @JsonProperty("password")String password){
        super();
        this.idSupervisor = idSupervisor;
        this.username = username;
        this.password = password;
    }

    public SupervisorDTO toDTO(){
        SupervisorDTO dto = new SupervisorDTO();
        dto.setIdSupervisor(this.getIdSupervisor());
        dto.setUsername(this.getUsername());
        dto.setPassword(this.getPassword());

        if(this.admin != null){
            dto.setAdmin(this.admin.toDTO());
        }

        return dto;
    }
}
