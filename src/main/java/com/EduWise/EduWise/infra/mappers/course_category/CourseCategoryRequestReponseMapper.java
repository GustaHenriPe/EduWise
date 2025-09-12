package com.EduWise.EduWise.infra.mappers.course_category;

import com.EduWise.EduWise.core.domain.CourseCategory;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryRequest;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseCategoryRequestReponseMapper {

    public CourseCategory toDomain(CourseCategoryRequest request) {
        return new CourseCategory(
                request.title()
        );
    }

    public CourseCategoryResponse toResponse(CourseCategory courseCategory) {
        return new CourseCategoryResponse(
                courseCategory.id(),
                courseCategory.title(),
                courseCategory.createdAt(),
                courseCategory.updatedAt()
        );
    }

}
