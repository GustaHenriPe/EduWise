package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;

public class DeleteCourseCategoryUseCaseImpl implements DeleteCourseCategoryUseCase {

    private final CourseCategoryGateway gateway;

    public DeleteCourseCategoryUseCaseImpl(CourseCategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteCourseCategory(id);
    }
}
