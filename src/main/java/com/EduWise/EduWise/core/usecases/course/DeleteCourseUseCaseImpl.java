package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.gateway.CourseGateway;

public class DeleteCourseUseCaseImpl implements DeleteCourseUseCase{
    private final CourseGateway gateway;

    public DeleteCourseUseCaseImpl(CourseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteCourse(id);
    }
}
