package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.entities.Lesson;

import java.util.List;

public interface LessonGateway {
    Lesson createLesson(Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getAllLessons();

    Lesson updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);
}
