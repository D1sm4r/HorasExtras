package com.horasExtras.rest.repository;

import com.horasExtras.rest.entity.HorasExtras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasExtrasRepository extends JpaRepository<HorasExtras, Long> {
}
