package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    public List<AdminDTO> findAll();

    public Optional<AdminDTO> findById(long id);

    public AdminDTO save(AdminDTO admin);

    public void delete(AdminDTO dto);

}
