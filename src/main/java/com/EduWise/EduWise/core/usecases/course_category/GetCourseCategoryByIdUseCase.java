package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.CourseCategory;

public interface GetCourseCategoryByIdUseCase {
    CourseCategory execute(Long id);
}
