package com.EduWise.EduWise.infra.mappers.student_enrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentRequest;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentResponse;
import com.EduWise.EduWise.infra.gateway.CourseRepositoryGateway;
import com.EduWise.EduWise.infra.gateway.UserRepositoryGateway;
import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class StudentEnrollmentRequestResponseMapper {

    private final CourseRepositoryGateway courseGateway;
    private final UserRepositoryGateway userGateway;

    public StudentEnrollment toDomain(EnrollmentRequest request) {
        return new StudentEnrollment(
                request.studentId(),
                request.courseId()
        );
    }

    public EnrollmentResponse toResponse(StudentEnrollment studentEnrollment) {
        CourseEntity course = courseGateway.verifyExistingCourse(studentEnrollment.courseId());
        UserEntity user = userGateway.verifyUserById(studentEnrollment.userId());

        return new EnrollmentResponse(
                studentEnrollment.id(),
                user.getName(),
                course.getTitle(),
                studentEnrollment.createdAt(),
                studentEnrollment.updatedAt()
        );
    }
}
