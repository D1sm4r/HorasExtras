package com.horasExtras.rest.Backend_HorasExtras.repository;

import com.horasExtras.rest.Backend_HorasExtras.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
