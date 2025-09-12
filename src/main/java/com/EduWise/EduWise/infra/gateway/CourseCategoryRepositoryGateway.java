package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.CourseCategory;
import com.EduWise.EduWise.core.gateway.CourseCategoryGateway;
import com.EduWise.EduWise.infra.mappers.course_category.CourseCategoryEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.CourseCategoryEntity;
import com.EduWise.EduWise.infra.persistence.repositories.CourseCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseCategoryRepositoryGateway implements CourseCategoryGateway {

    private final CourseCategoryRepository repository;
    private final CourseCategoryEntityMapper mapper;

    @Override
    public CourseCategory createCourseCategory(CourseCategory categorie) {
        CourseCategoryEntity savedCategory = repository.save(mapper.toEntity(categorie));
        return mapper.toDomain(savedCategory);
    }

    @Override
    public List<CourseCategory> getAllCourseCategories() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public CourseCategory getCourseCategoryById(Long id) {
        CourseCategoryEntity courseCategory = verifyExistingCourseCategory(id);
        return mapper.toDomain(courseCategory);
    }

    @Override
    public CourseCategory updateCourseCategory(Long id, CourseCategory courseCategory) {
        CourseCategoryEntity existingCategory = verifyExistingCourseCategory(id);
        existingCategory.setTitle(courseCategory.title());
        CourseCategoryEntity updatedCategory = repository.save(existingCategory);
        return mapper.toDomain(updatedCategory);
    }

    @Override
    public void deleteCourseCategory(Long id) {
        CourseCategoryEntity existingCategory = verifyExistingCourseCategory(id);
        repository.delete(existingCategory);
    }

    public CourseCategoryEntity verifyExistingCourseCategory(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course Category not found with ID: " + id));
    }
}

