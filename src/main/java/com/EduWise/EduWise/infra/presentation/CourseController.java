package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.core.usecases.course.*;
import com.EduWise.EduWise.infra.dtos.course.CourseRequest;
import com.EduWise.EduWise.infra.dtos.course.CourseResponse;
import com.EduWise.EduWise.infra.mappers.course.CourseRequestResponseMapper;
import com.EduWise.EduWise.infra.presentation.api.CourseApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses/")
public class CourseController implements CourseApi {

    private final CourseRequestResponseMapper mapper;
    private final CreateCourseUseCase createCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;
    private final GetCourseByIdUseCase getCourseByIdUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    @Override
    @PostMapping()
    public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseRequest request) {
        Course savedCourse = createCourseUseCase.execute(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedCourse));
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courses = getAllCoursesUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
        Course course = getCourseByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(course));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest request) {
        Course updatedCourse = updateCourseUseCase.execute(id, mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(updatedCourse));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        deleteCourseUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
