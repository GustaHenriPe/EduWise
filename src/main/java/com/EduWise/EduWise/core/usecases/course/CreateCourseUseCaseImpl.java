package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;

public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseGateway gateway;

    public CreateCourseUseCaseImpl(CourseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Course execute(Course course) {
        return gateway.createCourse(course);
    }
}
