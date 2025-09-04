package com.EduWise.EduWise.core.usecases.coursecategorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;

import java.util.List;

public interface GetAllCourseCategoriesUseCase {
    List<CourseCategorie> execute();
}
