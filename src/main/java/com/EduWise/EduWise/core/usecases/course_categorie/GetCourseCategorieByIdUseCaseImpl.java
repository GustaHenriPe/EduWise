package com.EduWise.EduWise.core.usecases.course_categorie;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;

public class GetCourseCategorieByIdUseCaseImpl implements GetCourseCategorieByIdUseCase {

    private final CourseCategorieGateway gateway;

    public GetCourseCategorieByIdUseCaseImpl(CourseCategorieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CourseCategorie execute(Long id) {
        return gateway.getCourseCategorieById(id);
    }
}
