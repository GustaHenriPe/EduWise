package com.EduWise.EduWise.infra.persistence.repositories;

import com.EduWise.EduWise.infra.persistence.entities.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
}

