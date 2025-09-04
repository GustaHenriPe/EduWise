package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;

import java.util.List;

public class GetAllCoursesUseCaseImpl implements GetAllCoursesUseCase{
    private final CourseGateway gateway;

    public GetAllCoursesUseCaseImpl(CourseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Course> execute() {
        return gateway.getAllCourses();
    }
}
