package com.EduWise.EduWise.core.usecases.course_category;

import com.EduWise.EduWise.core.domain.CourseCategory;
import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;

import java.util.List;

public class GetAllCourseCategoriesUseCaseImpl implements GetAllCourseCategoriesUseCase {

    private final CourseCategoryGateway gateway;

    public GetAllCourseCategoriesUseCaseImpl(CourseCategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<CourseCategory> execute() {
        return gateway.getAllCourseCategories();
    }
}
