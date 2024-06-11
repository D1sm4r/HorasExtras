package com.example.demo.frontend.equipo20.service;

import java.util.List;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;

public interface IPersonaService {

	public List<PersonaDTO> findAllREST();

	public PersonaDTO findByIdREST(Long id);

	public PersonaDTO saveREST(PersonaDTO persona);

	public PersonaDTO deleteREST(Long id);
}
