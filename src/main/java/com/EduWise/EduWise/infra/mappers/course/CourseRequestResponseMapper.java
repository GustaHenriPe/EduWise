package com.EduWise.EduWise.infra.mappers.course;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.infra.dtos.course.CourseRequest;
import com.EduWise.EduWise.infra.dtos.course.CourseResponse;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import com.EduWise.EduWise.infra.persistence.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CourseRequestResponseMapper {
    private final UserRepository userRepository;

    public Course toDomain(CourseRequest courseRequest) {
        return new Course(
                courseRequest.id(),
                courseRequest.teacherId(),
                courseRequest.title(),
                courseRequest.description(),
                courseRequest.createdAt(),
                courseRequest.updatedAt()
        );
    }

    public CourseResponse toResponse(Course course) {
        UserEntity teacher = userRepository.findById(course.teacherId())
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        return new CourseResponse(
                course.id(),
                course.title(),
                course.description(),
                course.createdAt(),
                course.updatedAt(),
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail()
        );

    }

}
