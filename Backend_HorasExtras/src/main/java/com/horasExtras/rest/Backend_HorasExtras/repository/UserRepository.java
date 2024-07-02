package com.horasExtras.rest.Backend_HorasExtras.repository;

import com.horasExtras.rest.Backend_HorasExtras.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

}
