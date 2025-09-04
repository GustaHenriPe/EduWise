package com.EduWise.EduWise.core.usecases.coursecategorie;

import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;

public class DeleteCourseCategorieUseCaseImpl implements DeleteCourseCategorieUseCase {

    private final CourseCategorieGateway gateway;

    public DeleteCourseCategorieUseCaseImpl(CourseCategorieGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteCourseCategorie(id);
    }
}
