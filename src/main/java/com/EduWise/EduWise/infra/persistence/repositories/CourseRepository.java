package com.EduWise.EduWise.infra.persistence.repositories;

import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}

