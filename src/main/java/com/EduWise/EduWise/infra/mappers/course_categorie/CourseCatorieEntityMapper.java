package com.EduWise.EduWise.infra.mappers.course_categorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.infra.persistence.entities.CourseCategorieEntity;

public class CourseCatorieEntityMapper {

    public CourseCategorieEntity toEntity(CourseCategorie domain) {
        CourseCategorieEntity entity = new CourseCategorieEntity();
        entity.setId(domain.id());
        entity.setTitle(domain.title());
        return entity;
    }

    public CourseCategorie toDomain(CourseCategorieEntity entity) {
        return new CourseCategorie();
    }
}
