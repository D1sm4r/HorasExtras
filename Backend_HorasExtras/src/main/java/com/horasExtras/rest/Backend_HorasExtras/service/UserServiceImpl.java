package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.RoleDTO;
import com.horasExtras.rest.Backend_HorasExtras.dto.UserDTO;
import com.horasExtras.rest.Backend_HorasExtras.entity.Cargo;
import com.horasExtras.rest.Backend_HorasExtras.entity.RoleEntity;
import com.horasExtras.rest.Backend_HorasExtras.entity.UserEntity;
import com.horasExtras.rest.Backend_HorasExtras.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> listE = (List<UserEntity>) userRepository.findAll();
        List<UserDTO> listDTO = new ArrayList<UserDTO>();
        for (UserEntity e : listE) {
            UserDTO UserDTO = e.toDTO();

            Cargo Cargo = e.getCargo();
            if (Cargo != null) {
                UserDTO.setCargo(Cargo.toDTO());
            }

            Set<RoleEntity> RoleEntity = e.getRoles();
            if (RoleEntity != null) {
                Set<RoleDTO> roleDTOs = RoleEntity.stream()
                        .map(roleEntity -> roleEntity.toDTO())
                        .collect(Collectors.toSet());
                UserDTO.setRoles(roleDTOs);
            }

            listDTO.add(UserDTO);
        }
        return listDTO;
    }

    @Override
    public Optional<UserDTO> findById(long id) {
        Optional<UserEntity> oe = userRepository.findById(id);
        UserEntity e = oe.get();
        UserDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity e = userRepository.save(user.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(UserDTO b) {
        userRepository.delete(b.toEntity());
    }

}
