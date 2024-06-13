package com.horasExtras.rest.Backend_HorasExtras.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horasExtras.rest.Backend_HorasExtras.dto.EmpleadoDTO;
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
    @Column(name = "password")
    private String password;

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idCargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

    //------------------------------------------------------------

    public Empleado(@JsonProperty("id")long id, @JsonProperty("username") String username,
                    @JsonProperty("password") String password){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public EmpleadoDTO toDTO(){
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(this.getId());
        dto.setUsername(this.getUsername());
        dto.setPassword(this.getPassword());

        if(this.cargo != null){
            dto.setCargo(this.getCargo().toDTO());
        }
        if(this.admin != null){
            dto.setAdmin(this.getAdmin().toDTO());
        }
        return dto;
    }

}
