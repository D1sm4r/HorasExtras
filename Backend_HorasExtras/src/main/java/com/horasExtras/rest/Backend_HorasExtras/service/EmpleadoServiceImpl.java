package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.EmpleadoDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Admin;
import com.horasExtras.rest.Backend_HorasExtras.entity.Cargo;
import com.horasExtras.rest.Backend_HorasExtras.entity.Empleado;
import com.horasExtras.rest.Backend_HorasExtras.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository beta;

    @Override
    public List<EmpleadoDTO> findAll() {
        List<Empleado> listE = (List<Empleado>) beta.findAll();
        List<EmpleadoDTO> listDto = new ArrayList<EmpleadoDTO>();
        for (Empleado e : listE) {
            EmpleadoDTO EmpleadoDTO = e.toDTO();

            Admin Admin = e.getAdmin();
            if(Admin != null) {
               EmpleadoDTO.setAdmin(Admin.toDTO());
            }

            Cargo Cargo = e.getCargo();
            if(Cargo != null) {
                EmpleadoDTO.setCargo(Cargo.toDTO());
            }

            listDto.add(EmpleadoDTO);
        }
        return listDto;
    }

    @Override
    public Optional<EmpleadoDTO> findById(long id) {
        Optional<Empleado> oe = beta.findById(id);
        Empleado e = oe.get();
        EmpleadoDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public EmpleadoDTO save(EmpleadoDTO empleado) {
        Empleado e = beta.save(empleado.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(EmpleadoDTO B) {
        beta.delete(B.toEntity());
    }
}
