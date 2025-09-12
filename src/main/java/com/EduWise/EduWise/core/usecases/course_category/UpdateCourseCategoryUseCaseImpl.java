package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;
import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;

public class UpdateCourseCategoryUseCaseImpl implements UpdateCourseCategoryUseCase {

    private final CourseCategoryGateway gateway;

    public UpdateCourseCategoryUseCaseImpl(CourseCategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategory execute(Long id, CourseCategory courseCategory) {
        return gateway.updateCourseCategory(id, courseCategory);
    }
}
