package com.EduWise.EduWise.infra.mappers.course;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityMapper {

    public CourseEntity toEntity(Course domain) {
        CourseEntity entity = new CourseEntity();
        entity.setTitle(domain.title());
        entity.setDescription(domain.description());
        return entity;
    }

    public Course toDomain(CourseEntity entity) {
        return new Course(
                entity.getId(),
                entity.getTeacher().getId(),
                entity.getCategory().getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

