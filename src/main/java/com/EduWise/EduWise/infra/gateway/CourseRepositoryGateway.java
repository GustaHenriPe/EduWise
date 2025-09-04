package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseRepositoryGateway implements CourseGateway {
    @Override
    public Course createCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
    }
}

