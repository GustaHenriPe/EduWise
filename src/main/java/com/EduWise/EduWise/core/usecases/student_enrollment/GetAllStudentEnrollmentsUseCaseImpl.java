package com.EduWise.EduWise.core.usecases.student_enrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;

import java.util.List;

public class GetAllStudentEnrollmentsUseCaseImpl implements GetAllStudentEnrollmentsUseCase {

    private final StudentEnrollmentGateway gateway;

    public GetAllStudentEnrollmentsUseCaseImpl(StudentEnrollmentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<StudentEnrollment> execute() {
        return gateway.getAllStudentEnrollments();
    }
}
