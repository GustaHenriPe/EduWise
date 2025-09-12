package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.CourseCategory;
import com.EduWise.EduWise.core.usecases.course_category.*;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryRequest;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryResponse;
import com.EduWise.EduWise.infra.mappers.course_category.CourseCatorieRequestReponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course-categories/")
public class CourseCategoryController {
    private final CourseCatorieRequestReponseMapper mapper;
    private final CreateCourseCategoryUseCase createCourseCategoryUseCase;
    private final GetAllCourseCategoriesUseCase getAllCourseCategoriesUseCase;
    private final GetCourseCategoryByIdUseCase getCourseCategoryByIdUseCase;
    private final UpdateCourseCategoryUseCase updateCourseCategoryUseCase;
    private final DeleteCourseCategoryUseCase deleteCourseCategoryUseCase;

    @PostMapping()
    public CourseCategoryResponse createCourseCategory(@RequestBody CourseCategoryRequest request) {
        CourseCategory savedCategorie = createCourseCategoryUseCase
                .execute(mapper.toDomain(request));
        return mapper.toResponse(savedCategorie);
    }

    @GetMapping()
    public List<CourseCategoryResponse> getAllCourseCategories() {
        List<CourseCategory> categories = getAllCourseCategoriesUseCase.execute();
        return categories.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("{id}")
    public CourseCategoryResponse getCourseCategoryById(@PathVariable Long id) {
        CourseCategory categorie = getCourseCategoryByIdUseCase.execute(id);
        return mapper.toResponse(categorie);
    }

    @PutMapping("{id}")
    public CourseCategoryResponse updateCourseCategory(@PathVariable Long id, @RequestBody CourseCategoryRequest request) {
        CourseCategory updatedCategorie = updateCourseCategoryUseCase
                .execute(id, mapper.toDomain(request));
        return mapper.toResponse(updatedCategorie);
    }

    @DeleteMapping("{id}")
    public void deleteCourseCategory(@PathVariable Long id) {
        deleteCourseCategoryUseCase.execute(id);
    }
}
