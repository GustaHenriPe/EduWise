package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;

public interface UpdateLessonUseCase {
    Lesson execute(Long id, Lesson lesson);
}
