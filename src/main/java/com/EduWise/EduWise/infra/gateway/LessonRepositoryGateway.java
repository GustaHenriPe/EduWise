package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.core.domain.exceptions.LessonNotFoundException;
import com.EduWise.EduWise.core.gateway.LessonGateway;
import com.EduWise.EduWise.infra.mappers.lesson.LessonEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.LessonEntity;
import com.EduWise.EduWise.infra.persistence.entities.ModuleEntity;
import com.EduWise.EduWise.infra.persistence.repositories.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LessonRepositoryGateway implements LessonGateway {

    private final LessonRepository repository;
    private final LessonEntityMapper mapper;
    private final ModuleRepositoryGateway moduleRepositoryGateway;


    @Override
    public Lesson createLesson(Lesson lesson) {
        ModuleEntity moduleEntity = moduleRepositoryGateway
                .verifyExistingModule(lesson.moduleId());

        LessonEntity lessonEntity = mapper.toEntity(lesson);

        lessonEntity.setModuleEntity(moduleEntity);

        LessonEntity savedLesson = repository.save(lessonEntity);

        return mapper.toDomain(savedLesson);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Lesson getLessonById(Long id) {
        LessonEntity lessonEntity = verifyLessonById(id);
        return mapper.toDomain(lessonEntity);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        LessonEntity existingLesson = verifyLessonById(id);

        ModuleEntity moduleEntity = moduleRepositoryGateway
                .verifyExistingModule(lesson.moduleId());

        existingLesson.setTitle(lesson.title());
        existingLesson.setContentType(lesson.contentType());
        existingLesson.setVideoUrl(lesson.videoUrl());
        existingLesson.setTextContent(lesson.textContent());
        existingLesson.setModuleEntity(moduleEntity);

        LessonEntity updatedLesson = repository.save(existingLesson);
        return mapper.toDomain(updatedLesson);
    }

    @Override
    public void deleteLesson(Long id) {
        LessonEntity existingLesson = verifyLessonById(id);
        repository.delete(existingLesson);
    }

    public LessonEntity verifyLessonById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
    }

}

