package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.CourseCategorie;
import com.EduWise.EduWise.core.gateway.CourseCategorieGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseCategorieRepositoryGateway implements CourseCategorieGateway {
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

