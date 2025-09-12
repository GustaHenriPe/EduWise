package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;

public interface CreateCourseCategoryUseCase {
    CourseCategory execute(CourseCategory courseCategory);
}
