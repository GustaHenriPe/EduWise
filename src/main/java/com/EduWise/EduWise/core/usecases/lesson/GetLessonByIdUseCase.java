package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.Lesson;

public interface GetLessonByIdUseCase {
    Lesson execute(Long id);
}
