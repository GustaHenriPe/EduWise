package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.core.gateway.LessonGateway;

public class GetLessonByIdUseCaseImpl implements GetLessonByIdUseCase {

    private final LessonGateway gateway;

    public GetLessonByIdUseCaseImpl(LessonGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Lesson execute(Long id) {
        return gateway.getLessonById(id);
    }
}
