package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.AdminDTO;

import java.util.List;

public interface IAdminService {

    public List<AdminDTO> findAllREST();

    public AdminDTO findByIdREST(Long id);

    public AdminDTO saveREST(AdminDTO admin);

    public AdminDTO deleteREST(Long id);
}
