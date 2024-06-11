package com.example.demo.frontend.equipo20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorDTO {

    private long idSupervisor;

    private String username;

    private String contraseña;

    //------------------------------------------------------------

    private AdminDTO admin;

    //------------------------------------------------------------


}
