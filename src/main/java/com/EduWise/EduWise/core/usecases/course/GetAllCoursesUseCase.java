package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.entities.Course;

import java.util.List;

public interface GetAllCoursesUseCase {

    List<Course> execute();
}
