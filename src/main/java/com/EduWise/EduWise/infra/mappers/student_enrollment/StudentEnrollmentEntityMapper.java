package com.EduWise.EduWise.infra.mappers.student_enrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.infra.persistence.entities.StudentEnrollmentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentEnrollmentEntityMapper {

    public StudentEnrollmentEntity toEntity(StudentEnrollment domain) {
        StudentEnrollmentEntity entity = new StudentEnrollmentEntity();
        entity.setId(domain.id());
        return entity;
    }

    public StudentEnrollment toDomain(StudentEnrollmentEntity entity) {
        return new StudentEnrollment(
                entity.getId(),
                entity.getUserEntity().getId(),
                entity.getCourseEntity().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
