package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.CourseCategory;

import java.util.List;

public interface GetAllCourseCategoriesUseCase {
    List<CourseCategory> execute();
}
