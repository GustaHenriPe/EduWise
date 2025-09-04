package com.EduWise.EduWise.infra.persistence.repositories;

import com.EduWise.EduWise.infra.persistence.entities.CourseCategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCategorieRepository extends JpaRepository<CourseCategorieEntity, Long> {
}

