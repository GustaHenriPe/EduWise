package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.Lesson;
import com.EduWise.EduWise.core.gateway.LessonGateway;

import java.util.List;

public class GetAllLessonsUseCaseImpl implements GetAllLessonsUseCase {

    private final LessonGateway gateway;

    public GetAllLessonsUseCaseImpl(LessonGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Lesson> execute() {
        return gateway.getAllLessons();
    }
}
