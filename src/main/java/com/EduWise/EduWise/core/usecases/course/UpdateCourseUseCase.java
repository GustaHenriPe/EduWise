package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.entities.Course;

public interface UpdateCourseUseCase {
    Course execute(Long id, Course course);
}
