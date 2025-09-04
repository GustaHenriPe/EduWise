package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;

public class GetCourseByIdUseCaseImpl implements GetCourseByIdUseCase {
    private final CourseGateway gateway;

    public GetCourseByIdUseCaseImpl(CourseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Course execute(Long id) {
        return gateway.getCourseById(id);
    }
}
