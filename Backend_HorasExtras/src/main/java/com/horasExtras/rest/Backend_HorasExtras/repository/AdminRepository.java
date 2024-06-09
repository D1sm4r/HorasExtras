package com.horasExtras.rest.Backend_HorasExtras.repository;

import com.horasExtras.rest.Backend_HorasExtras.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
