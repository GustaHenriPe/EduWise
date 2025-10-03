package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.core.usecases.lesson.*;
import com.EduWise.EduWise.infra.dtos.lesson.LessonRequest;
import com.EduWise.EduWise.infra.dtos.lesson.LessonResponse;
import com.EduWise.EduWise.infra.mappers.lesson.LessonRequestResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lessons/")
public class LessonController {

    private final CreateLessonUseCase createLessonUseCase;
    private final GetAllLessonsUseCase getAllLessonsUseCase;
    private final GetLessonByIdUseCase getLessonByIdUseCase;
    private final UpdateLessonUseCase updateLessonUseCase;
    private final DeleteLessonUseCase deleteLessonUseCase;
    private final LessonRequestResponseMapper mapper;

    @PostMapping()
    public ResponseEntity<LessonResponse> createLesson(@Valid @RequestBody LessonRequest lessonRequest) {
        Lesson savedLesson = createLessonUseCase.execute(mapper.toDomain(lessonRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedLesson));
    }

    @GetMapping()
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        List<LessonResponse> lessons = getAllLessonsUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(lessons);
    }

    @GetMapping("{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Lesson lesson = getLessonByIdUseCase.execute(id);
        return ResponseEntity.ok(lesson);
    }

    @PutMapping("{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id, @Valid @RequestBody LessonRequest lessonRequest) {
        Lesson updatedLesson = updateLessonUseCase.execute(id, mapper.toDomain(lessonRequest));
        return ResponseEntity.ok(mapper.toResponse(updatedLesson));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        deleteLessonUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
