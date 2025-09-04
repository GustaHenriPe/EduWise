package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;

public class CreateStudentEnrollmentUseCaseImpl implements CreateStudentEnrollmentUseCase {

    private final StudentEnrollmentGateway gateway;

    public CreateStudentEnrollmentUseCaseImpl(StudentEnrollmentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public StudentEnrollment execute(StudentEnrollment studentEnrollment) {
        return gateway.createStudentEnrollment(studentEnrollment);
    }
}
