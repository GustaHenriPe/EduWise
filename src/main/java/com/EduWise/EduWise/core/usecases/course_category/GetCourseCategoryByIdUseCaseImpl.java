package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;
import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;

public class GetCourseCategoryByIdUseCaseImpl implements GetCourseCategoryByIdUseCase {

    private final CourseCategoryGateway gateway;

    public GetCourseCategoryByIdUseCaseImpl(CourseCategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategory execute(Long id) {
        return gateway.getCourseCategoryById(id);
    }
}
