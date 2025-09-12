package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;

public interface GetCourseCategoryByIdUseCase {
    CourseCategory execute(Long id);
}
