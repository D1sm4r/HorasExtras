package com.horasExtras.rest.Backend_HorasExtras.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private long id;

    private String username;

    private String contraseña;

    private CargoDTO cargo;

    private AdminDTO adminDTO;
}
