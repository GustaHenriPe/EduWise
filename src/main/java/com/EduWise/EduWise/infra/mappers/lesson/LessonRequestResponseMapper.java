package com.EduWise.EduWise.infra.mappers.lesson;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.infra.dtos.lesson.LessonRequest;
import com.EduWise.EduWise.infra.dtos.lesson.LessonResponse;
import com.EduWise.EduWise.infra.gateway.ModuleRepositoryGateway;
import com.EduWise.EduWise.infra.persistence.entities.ModuleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LessonRequestResponseMapper {

    private final ModuleRepositoryGateway moduleRepositoryGateway;

    public Lesson toDomain(LessonRequest lessonRequest) {
        return new Lesson(
                lessonRequest.moduleId(),
                lessonRequest.title(),
                lessonRequest.contentType(),
                lessonRequest.videoUrl(),
                lessonRequest.textContent()
        );
    }

    public LessonResponse toResponse(Lesson lesson) {
        ModuleEntity moduleEntity = moduleRepositoryGateway.verifyExistingModule(lesson.moduleId());
        return new LessonResponse(
                lesson.id(),
                moduleEntity.getTitle(),
                lesson.title(),
                lesson.contentType(),
                lesson.videoUrl(),
                lesson.textContent(),
                lesson.createdAt(),
                lesson.updatedAt()
        );
    }
}
