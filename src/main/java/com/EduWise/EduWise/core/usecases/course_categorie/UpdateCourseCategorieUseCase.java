package com.EduWise.EduWise.core.usecases.course_categorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;

public interface UpdateCourseCategorieUseCase {
    CourseCategorie execute(Long id, CourseCategorie courseCategorie);
}
