package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.CargoDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Cargo;
import com.horasExtras.rest.Backend_HorasExtras.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class CargoServiceImpl implements ICargoService {

    @Autowired
    private CargoRepository beta;

    @Override
    public List<CargoDTO> findAll() {
        List<Cargo> listE = (List<Cargo>) beta.findAll();
        List<CargoDTO> listDto = new ArrayList<CargoDTO>();
        for (Cargo e : listE) {
            listDto.add(e.toDTO());
        }
        return listDto;
    }

    @Override
    public Optional<CargoDTO> findById(long id) {
        Optional<Cargo> oe = beta.findById(id);
        Cargo e = oe.get();
        CargoDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public CargoDTO save(CargoDTO cargo) {
        Cargo e = beta.save(cargo.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(CargoDTO B) {
        beta.delete(B.toEntity());
    }

}
