package com.EduWise.EduWise.infra.mappers.course_category;

import com.EduWise.EduWise.core.domain.CourseCategory;
import com.EduWise.EduWise.infra.persistence.entities.CourseCategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseCategoryEntityMapper {

    public CourseCategoryEntity toEntity(CourseCategory domain) {
        CourseCategoryEntity entity = new CourseCategoryEntity();
        entity.setTitle(domain.title());
        return entity;
    }

    public CourseCategory toDomain(CourseCategoryEntity entity) {
        return new CourseCategory(
                entity.getId(),
                entity.getTitle(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
