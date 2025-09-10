package com.EduWise.EduWise.core.usecases.student_enrollment;

import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;

public class DeleteStudentEnrollmentUseCaseImpl implements DeleteStudentEnrollmentUseCase {

    private final StudentEnrollmentGateway gateway;

    public DeleteStudentEnrollmentUseCaseImpl(StudentEnrollmentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteStudentEnrollment(id);
    }
}
