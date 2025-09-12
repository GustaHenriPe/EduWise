package com.EduWise.EduWise.infra.mappers.course;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.infra.dtos.course.CourseRequest;
import com.EduWise.EduWise.infra.dtos.course.CourseResponse;
import com.EduWise.EduWise.infra.gateway.CourseCategoryRepositoryGateway;
import com.EduWise.EduWise.infra.gateway.UserRepositoryGateway;
import com.EduWise.EduWise.infra.persistence.entities.CourseCategoryEntity;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CourseRequestResponseMapper {
    private final UserRepositoryGateway userGateway;
    private final CourseCategoryRepositoryGateway categoryGateway;

    public Course toDomain(CourseRequest courseRequest) {
        return new Course(
                courseRequest.teacherId(),
                courseRequest.title(),
                courseRequest.description(),
                courseRequest.categoryId()
        );
    }

    public CourseResponse toResponse(Course course) {
        UserEntity teacher = userGateway.verifyUserById(course.teacherId());
        CourseCategoryEntity category = categoryGateway.verifyExistingCourseCategory(course.categoryId());

        return new CourseResponse(
                course.id(),
                course.title(),
                course.description(),
                course.createdAt(),
                course.updatedAt(),
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                category.getTitle()
        );

    }

}
