package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;

public class UpdateStudentEnrollmentUseCaseImpl implements UpdateStudentEnrollmentUseCase {

    private final StudentEnrollmentGateway gateway;

    public UpdateStudentEnrollmentUseCaseImpl(StudentEnrollmentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public StudentEnrollment execute(Long id, StudentEnrollment studentEnrollment) {
        return gateway.updateStudentEnrollment(id, studentEnrollment);
    }
}
