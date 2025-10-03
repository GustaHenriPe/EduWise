package com.EduWise.EduWise.infra.mappers.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.infra.persistence.entities.LessonEntity;
import org.springframework.stereotype.Component;

@Component
public class LessonEntityMapper {

    public LessonEntity toEntity(Lesson lesson) {
        LessonEntity entity = new LessonEntity();

        entity.setTitle(lesson.title());
        entity.setContentType(lesson.contentType());
        entity.setVideoUrl(lesson.videoUrl());
        entity.setTextContent(lesson.textContent());

        return entity;
    }

    public Lesson toDomain(LessonEntity entity) {
        return new Lesson(
                entity.getId(),
                entity.getModuleEntity().getId(),
                entity.getTitle(),
                entity.getContentType(),
                entity.getVideoUrl(),
                entity.getTextContent(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
