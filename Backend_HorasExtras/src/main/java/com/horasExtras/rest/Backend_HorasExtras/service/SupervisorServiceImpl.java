package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.SupervisorDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Admin;
import com.horasExtras.rest.Backend_HorasExtras.entity.Supervisor;
import com.horasExtras.rest.Backend_HorasExtras.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class SupervisorServiceImpl implements ISupervisorService {

    @Autowired
    private SupervisorRepository beta;

    @Override
    public List<SupervisorDTO> findAll() {
        List<Supervisor> listE = (List<Supervisor>) beta.findAll();
        List<SupervisorDTO> listDto = new ArrayList<SupervisorDTO>();
        for (Supervisor e : listE) {
            SupervisorDTO SupervisorDTO = e.toDTO();

            Admin Admin = e.getAdmin();
            if(Admin != null) {
                SupervisorDTO.setAdmin(Admin.toDTO());
            }

            listDto.add(SupervisorDTO);
        }
        return listDto;
    }

    @Override
    public Optional<SupervisorDTO> findById(long id) {
        Optional<Supervisor> oe = beta.findById(id);
        Supervisor e = oe.get();
        SupervisorDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public SupervisorDTO save(SupervisorDTO supervisor) {
        Supervisor e = beta.save(supervisor.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(SupervisorDTO B) {
        beta.delete(B.toEntity());
    }
}
