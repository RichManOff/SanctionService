package com.example.sanction_service.repository;

import com.example.sanction_service.model.SanctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanctionRepository extends JpaRepository<SanctionEntity, Long> {
}
