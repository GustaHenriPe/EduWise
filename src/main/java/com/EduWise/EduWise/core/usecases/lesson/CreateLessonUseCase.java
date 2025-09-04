package com.EduWise.EduWise.core.usecases.lesson;

import com.EduWise.EduWise.core.domain.Lesson;

public interface CreateLessonUseCase {
    Lesson execute(Lesson lesson);
}
