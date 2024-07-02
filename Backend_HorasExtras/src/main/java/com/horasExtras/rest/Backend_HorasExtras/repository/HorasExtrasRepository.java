package com.horasExtras.rest.Backend_HorasExtras.repository;

import com.horasExtras.rest.Backend_HorasExtras.entity.HorasExtras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasExtrasRepository extends JpaRepository<HorasExtras, Long> {
}
