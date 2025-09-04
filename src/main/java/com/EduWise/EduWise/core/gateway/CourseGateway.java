package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.Course;

import java.util.List;

public interface CourseGateway {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
