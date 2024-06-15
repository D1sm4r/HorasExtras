package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.AdminDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Admin;
import com.horasExtras.rest.Backend_HorasExtras.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository beta;

    @Override
    public List<AdminDTO> findAll() {
        List<Admin> listE = (List< Admin>) beta.findAll();
        List<AdminDTO> listDto = new ArrayList<AdminDTO>();
        for (Admin e : listE) {
            listDto.add(e.toDTO());
        }
        return listDto;
    }

    @Override
    public Optional<AdminDTO> findById(long id) {
        Optional<Admin> oe = beta.findById(id);
        Admin e = oe.get();
        AdminDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public AdminDTO save(AdminDTO admin) {
        Admin e = beta.save(admin.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(AdminDTO B) {
        beta.delete(B.toEntity());
    }

}
