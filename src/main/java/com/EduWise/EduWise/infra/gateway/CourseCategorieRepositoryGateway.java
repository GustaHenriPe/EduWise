package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;
import com.EduWise.EduWise.infra.persistence.repositories.CourseCategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseCategorieRepositoryGateway implements CourseCategorieGateway {

    private final CourseCategorieRepository courseCategorieRepository;
    private final CourseCatorieEntityMapper mapper;

    @Override
    public CourseCategorie createCourseCategorie(CourseCategorie categorie) {
        return null;
    }

    @Override
    public List<CourseCategorie> getAllCourseCategories() {
        return List.of();
    }

    @Override
    public CourseCategorie getCourseCategorieById(Long id) {
        return null;
    }

    @Override
    public CourseCategorie updateCourseCategorie(CourseCategorie courseCategorie) {
        return null;
    }

    @Override
    public void deleteCourseCategorie(Long id) {
    }
}

