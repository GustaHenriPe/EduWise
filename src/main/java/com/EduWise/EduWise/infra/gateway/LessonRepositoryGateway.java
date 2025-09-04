package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.Lesson;
import com.EduWise.EduWise.core.gateway.LessonGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonRepositoryGateway implements LessonGateway {
    @Override
    public Lesson createLesson(Lesson lesson) {
        return null;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return List.of();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return null;
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return null;
    }

    @Override
    public void deleteLesson(Long id) {
    }
}

