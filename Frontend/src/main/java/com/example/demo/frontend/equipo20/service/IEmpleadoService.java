package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {

    public List<EmpleadoDTO> findAllREST();

    public EmpleadoDTO findByIdREST(Long id);

    public EmpleadoDTO saveREST(EmpleadoDTO empleado);

    public EmpleadoDTO deleteREST(Long id);
}
