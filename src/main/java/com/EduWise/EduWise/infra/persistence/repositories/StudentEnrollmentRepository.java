package com.EduWise.EduWise.infra.persistence.repositories;

import com.EduWise.EduWise.infra.persistence.entities.StudentEnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollmentEntity, Long> {
}

