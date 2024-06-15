package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.CargoDTO;

import java.util.List;

public interface ICargoService {

    public List<CargoDTO> findAllREST();

    public CargoDTO findByIdREST(Long id);

    public CargoDTO saveREST(CargoDTO cargo);

    public CargoDTO deleteREST(Long id);
}
