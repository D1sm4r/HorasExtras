package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;
import com.example.demo.frontend.equipo20.dto.ProyectoDTO;

import java.util.List;

public interface IProyectoService {

    public List<ProyectoDTO> findAllREST();

    public ProyectoDTO findByIdREST(Long id);

    public ProyectoDTO saveREST(ProyectoDTO proyecto);

    public ProyectoDTO deleteREST(Long id);
}
