package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.Lesson;
import com.EduWise.EduWise.core.gateway.LessonGateway;

public class CreateLessonUseCaseImpl implements CreateLessonUseCase {

    private final LessonGateway gateway;

    public CreateLessonUseCaseImpl(LessonGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Lesson execute(Lesson lesson) {
        return gateway.createLesson(lesson);
    }
}
