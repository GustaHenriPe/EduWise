package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;

import java.util.List;

public interface GetAllLessonsUseCase {
    List<Lesson> execute();
}
