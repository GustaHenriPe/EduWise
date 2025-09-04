package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;

public class GetStudentEnrollmentByIdUseCaseImpl implements GetStudentEnrollmentByIdUseCase {

    private final StudentEnrollmentGateway gateway;

    public GetStudentEnrollmentByIdUseCaseImpl(StudentEnrollmentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public StudentEnrollment execute(Long id) {
        return gateway.getStudentEnrollmentById(id);
    }
}
