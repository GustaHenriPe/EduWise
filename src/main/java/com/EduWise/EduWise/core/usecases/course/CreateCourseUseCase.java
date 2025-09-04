package com.EduWise.EduWise.core.usecases.course;


import com.EduWise.EduWise.core.domain.Course;

public interface CreateCourseUseCase {
    Course execute(Course course);
}
