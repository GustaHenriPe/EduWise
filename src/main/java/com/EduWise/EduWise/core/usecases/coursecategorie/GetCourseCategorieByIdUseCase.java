package com.EduWise.EduWise.core.usecases.coursecategorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;

public interface GetCourseCategorieByIdUseCase {
    CourseCategorie execute(Long id);
}
