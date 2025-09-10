package com.EduWise.EduWise.core.usecases.course_categorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;

public class CreateCourseCategorieUseCaseImpl implements CreateCourseCategorieUseCase {

    private final CourseCategorieGateway gateway;

    public CreateCourseCategorieUseCaseImpl(CourseCategorieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategorie execute(CourseCategorie courseCategorie) {
        return gateway.createCourseCategorie(courseCategorie);
    }
}
