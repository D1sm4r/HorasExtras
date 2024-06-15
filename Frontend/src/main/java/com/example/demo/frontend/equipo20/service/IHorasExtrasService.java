package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.HorasExtrasDTO;

import java.util.List;

public interface IHorasExtrasService {

    public List<HorasExtrasDTO> findAllREST();

    public HorasExtrasDTO findByIdREST(Long id);

    public HorasExtrasDTO saveREST(HorasExtrasDTO he);

    public HorasExtrasDTO deleteREST(Long id);
}
