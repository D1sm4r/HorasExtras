package com.example.demo.frontend.equipo20.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoDTO {

    private long idCargo;

    private String name;

    private String saldo;

    //------------------------------------------------------------


}
