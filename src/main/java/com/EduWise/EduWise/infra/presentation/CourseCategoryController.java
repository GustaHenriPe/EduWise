package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.CourseCategory;
import com.EduWise.EduWise.core.usecases.course_category.*;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryRequest;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryResponse;
import com.EduWise.EduWise.infra.mappers.course_category.CourseCategoryRequestReponseMapper;
import com.EduWise.EduWise.infra.presentation.api.CourseCategoryApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course-categories/")
public class CourseCategoryController implements CourseCategoryApi {
    private final CourseCategoryRequestReponseMapper mapper;
    private final CreateCourseCategoryUseCase createCourseCategoryUseCase;
    private final GetAllCourseCategoriesUseCase getAllCourseCategoriesUseCase;
    private final GetCourseCategoryByIdUseCase getCourseCategoryByIdUseCase;
    private final UpdateCourseCategoryUseCase updateCourseCategoryUseCase;
    private final DeleteCourseCategoryUseCase deleteCourseCategoryUseCase;

    @Override
    @PostMapping()
    public ResponseEntity<CourseCategoryResponse> createCourseCategory(@Valid @RequestBody CourseCategoryRequest request) {
        CourseCategory savedCategorie = createCourseCategoryUseCase
                .execute(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedCategorie));
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<CourseCategoryResponse>> getAllCourseCategories() {
        List<CourseCategory> categories = getAllCourseCategoriesUseCase.execute();
        List<CourseCategoryResponse> categoriesList = categories.stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(categoriesList);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<CourseCategoryResponse> getCourseCategoryById(@PathVariable Long id) {
        CourseCategory categorie = getCourseCategoryByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(categorie));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<CourseCategoryResponse> updateCourseCategory(@PathVariable Long id, @Valid @RequestBody CourseCategoryRequest request) {
        CourseCategory updatedCategorie = updateCourseCategoryUseCase
                .execute(id, mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(updatedCategorie));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseCategory(@PathVariable Long id) {
        deleteCourseCategoryUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
