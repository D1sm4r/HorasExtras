package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.EmpleadoDTO;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    public List<EmpleadoDTO> findAll();

    public Optional<EmpleadoDTO> findById(long id);

    public EmpleadoDTO save(EmpleadoDTO empleado);

    public void delete(EmpleadoDTO dto);
}
