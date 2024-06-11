package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;

import java.util.List;
import java.util.Optional;

public interface ISupervisorService {

    public List<SupervisorDTO> findAll();

    public Optional<SupervisorDTO> findById(long id);

    public SupervisorDTO save(SupervisorDTO supervisor);

    public void delete(SupervisorDTO dto);
}
