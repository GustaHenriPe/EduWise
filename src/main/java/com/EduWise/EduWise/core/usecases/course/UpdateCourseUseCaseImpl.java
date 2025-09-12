package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;

public class UpdateCourseUseCaseImpl implements UpdateCourseUseCase {
    private final CourseGateway gateway;

    public UpdateCourseUseCaseImpl(CourseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Course execute(Long id, Course course) {
        return gateway.updateCourse(id, course);
    }
}
