package com.EduWise.EduWise.core.usecases.coursecategorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;

public class UpdateCourseCategorieUseCaseImpl implements UpdateCourseCategorieUseCase {

    private final CourseCategorieGateway gateway;

    public UpdateCourseCategorieUseCaseImpl(CourseCategorieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategorie execute(Long id, CourseCategorie courseCategorie) {
        return gateway.updateCourseCategorie(courseCategorie);
    }
}
