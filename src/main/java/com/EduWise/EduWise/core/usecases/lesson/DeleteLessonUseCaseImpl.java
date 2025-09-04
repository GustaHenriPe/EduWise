package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.gateway.LessonGateway;

public class DeleteLessonUseCaseImpl implements DeleteLessonUseCase {

    private final LessonGateway gateway;

    public DeleteLessonUseCaseImpl(LessonGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteLesson(id);
    }
}
