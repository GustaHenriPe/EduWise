package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.core.usecases.course.*;
import com.EduWise.EduWise.infra.dtos.course.CourseRequest;
import com.EduWise.EduWise.infra.dtos.course.CourseResponse;
import com.EduWise.EduWise.infra.mappers.course.CourseRequestResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses/")
public class CourseController {

    private final CourseRequestResponseMapper mapper;
    private final CreateCourseUseCase createCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;
    private final GetCourseByIdUseCase getCourseByIdUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    @PostMapping()
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest request) {
        Course savedCourse = createCourseUseCase.execute(mapper.toDomain(request));
        return mapper.toResponse(savedCourse);
    }

    @GetMapping()
    public List<CourseResponse> getAllCourses() {
        return getAllCoursesUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        Course course = getCourseByIdUseCase.execute(id);
        return mapper.toResponse(course);
    }

    @PutMapping("{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequest request) {
        Course updatedCourse = updateCourseUseCase.execute(id, mapper.toDomain(request));
        return mapper.toResponse(updatedCourse);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id) {
        deleteCourseUseCase.execute(id);
    }
}
