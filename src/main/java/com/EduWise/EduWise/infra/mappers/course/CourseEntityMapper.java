package com.EduWise.EduWise.infra.mappers.course;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityMapper {

    public CourseEntity toEntity(Course domain) {
        CourseEntity entity = new CourseEntity();
        entity.setId(domain.id());
        entity.setTitle(domain.title());
        entity.setDescription(domain.description());
        entity.setCreatedAt(domain.createdAt());
        entity.setUpdatedAt(domain.updatedAt());
        return entity;
    }

    public Course toDomain(CourseEntity entity) {
        return new Course(
                entity.getId(),
                entity.getTeacher() != null ? entity.getTeacher().getId() : null,
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

