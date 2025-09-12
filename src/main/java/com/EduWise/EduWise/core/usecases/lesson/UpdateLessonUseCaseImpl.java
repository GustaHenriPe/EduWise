package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.core.gateway.LessonGateway;

public class UpdateLessonUseCaseImpl implements UpdateLessonUseCase {

    private final LessonGateway gateway;

    public UpdateLessonUseCaseImpl(LessonGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Lesson execute(Long id, Lesson lesson) {
        return gateway.updateLesson(id, lesson);
    }
}
