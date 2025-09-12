package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.CourseCategory;

import java.util.List;

public interface CourseCategoryGateway {
    CourseCategory createCourseCategory(CourseCategory courseCategory);

    List<CourseCategory> getAllCourseCategories();

    CourseCategory getCourseCategoryById(Long id);

    CourseCategory updateCourseCategory(Long id, CourseCategory courseCategory);

    void deleteCourseCategory(Long id);
}
