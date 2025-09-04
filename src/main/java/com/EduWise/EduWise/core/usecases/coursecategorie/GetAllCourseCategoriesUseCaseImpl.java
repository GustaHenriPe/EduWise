package com.EduWise.EduWise.core.usecases.coursecategorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;

import java.util.List;

public class GetAllCourseCategoriesUseCaseImpl implements GetAllCourseCategoriesUseCase {

    private final CourseCategorieGateway gateway;

    public GetAllCourseCategoriesUseCaseImpl(CourseCategorieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<CourseCategorie> execute() {
        return gateway.getAllCourseCategories();
    }
}
