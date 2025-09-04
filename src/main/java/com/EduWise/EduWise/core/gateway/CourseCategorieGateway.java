package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.CourseCategorie;

import java.util.List;
import java.util.Optional;

public interface CourseCategorieGateway {
    CourseCategorie createCourseCategorie(CourseCategorie courseCategorie);

    List<CourseCategorie> getAllCourseCategories();

    CourseCategorie getCourseCategorieById(Long id);

    CourseCategorie updateCourseCategorie(CourseCategorie courseCategorie);

    void deleteCourseCategorie(Long id);
}
