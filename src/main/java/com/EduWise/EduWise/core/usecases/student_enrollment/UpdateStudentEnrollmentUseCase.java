package com.EduWise.EduWise.core.usecases.student_enrollment;

import com.EduWise.EduWise.core.domain.entities.StudentEnrollment;

public interface UpdateStudentEnrollmentUseCase {
    StudentEnrollment execute(Long id, StudentEnrollment studentEnrollment);
}
