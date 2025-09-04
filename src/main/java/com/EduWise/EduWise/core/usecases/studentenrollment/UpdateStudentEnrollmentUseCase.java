package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;

public interface UpdateStudentEnrollmentUseCase {
    StudentEnrollment execute(Long id, StudentEnrollment studentEnrollment);
}
