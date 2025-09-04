package com.EduWise.EduWise.infra.persistence.repositories;

import com.EduWise.EduWise.infra.persistence.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}

