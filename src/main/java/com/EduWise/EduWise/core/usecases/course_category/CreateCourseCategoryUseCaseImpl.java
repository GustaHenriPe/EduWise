package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;
import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;

public class CreateCourseCategoryUseCaseImpl implements CreateCourseCategoryUseCase {

    private final CourseCategoryGateway gateway;

    public CreateCourseCategoryUseCaseImpl(CourseCategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategory execute(CourseCategory courseCategory) {
        return gateway.createCourseCategory(courseCategory);
    }
}
