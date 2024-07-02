package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    public List<UserDTO> findAll();

    public Optional<UserDTO> findById(long id);

    public UserDTO save(UserDTO user);

    public void delete(UserDTO dto);
}
