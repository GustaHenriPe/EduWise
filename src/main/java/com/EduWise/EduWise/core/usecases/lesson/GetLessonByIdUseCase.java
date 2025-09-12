package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;

public interface GetLessonByIdUseCase {
    Lesson execute(Long id);
}
