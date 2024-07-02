package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;

import java.util.List;
import java.util.Optional;

public interface IHorasExtrasService {

    HorasExtrasDTO solicitarHorasExtras(HorasExtrasDTO horasExtrasDTO);

    public List<HorasExtrasDTO> findAll();

    public Optional<HorasExtrasDTO> findById(long id);

    public HorasExtrasDTO save(HorasExtrasDTO horasExtras);

    public void delete(HorasExtrasDTO dto);
}
