package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;

public interface CreateStudentEnrollmentUseCase {
    StudentEnrollment execute(StudentEnrollment studentEnrollment);
}
