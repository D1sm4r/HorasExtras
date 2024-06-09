package com.horasExtras.rest.Backend_HorasExtras.repository;

import com.horasExtras.rest.Backend_HorasExtras.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
