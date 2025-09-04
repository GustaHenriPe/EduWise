package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;

public interface GetStudentEnrollmentByIdUseCase {
    StudentEnrollment execute(Long id);
}
