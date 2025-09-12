package com.EduWise.EduWise.core.usecases.student_enrollment;

import com.EduWise.EduWise.core.domain.entities.StudentEnrollment;

public interface CreateStudentEnrollmentUseCase {
    StudentEnrollment execute(StudentEnrollment studentEnrollment);
}
