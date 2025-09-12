package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;

public interface UpdateCourseCategoryUseCase {
    CourseCategory execute(Long id, CourseCategory courseCategory);
}
