package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;
import com.example.demo.frontend.equipo20.dto.SupervisorDTO;

import java.util.List;

public interface ISupervisorService {

    public List<SupervisorDTO> findAllREST();

    public SupervisorDTO findByIdREST(Long id);

    public SupervisorDTO saveREST(SupervisorDTO supervisor);

    public SupervisorDTO deleteREST(Long id);
}
