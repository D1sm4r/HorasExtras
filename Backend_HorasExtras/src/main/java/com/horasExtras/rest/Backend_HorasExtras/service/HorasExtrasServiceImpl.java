package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.HorasExtrasDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.*;
import com.horasExtras.rest.Backend_HorasExtras.repository.HorasExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class HorasExtrasServiceImpl implements IHorasExtrasService {

    @Autowired
    private HorasExtrasRepository beta;

    @Override
    public List<HorasExtrasDTO> findAll() {
        List<HorasExtras> listE = (List<HorasExtras>) beta.findAll();
        List<HorasExtrasDTO> listDTO = new ArrayList<HorasExtrasDTO>();
        for (HorasExtras e : listE) {
            HorasExtrasDTO HorasExtrasDTO = e.toDTO();

            Proyecto Proyecto = e.getProyecto();
            if (Proyecto != null) {
                HorasExtrasDTO.setProyecto(Proyecto.toDTO());
            }

            UserEntity UserEntity = e.getUser();
            if (UserEntity != null) {
                HorasExtrasDTO.setUser(UserEntity.toDTO());
            }

            listDTO.add(HorasExtrasDTO);
        }
        return listDTO;
    }

    @Override
    public Optional<HorasExtrasDTO> findById(long id) {
        Optional<HorasExtras> oe = beta.findById(id);
        HorasExtras e = oe.get();
        HorasExtrasDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public HorasExtrasDTO save(HorasExtrasDTO horasExtras) {
        HorasExtras e = beta.save(horasExtras.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(HorasExtrasDTO B) {
        beta.delete(B.toEntity());
    }

}
