package com.EduWise.EduWise.core.usecases.student_enrollment;

import com.EduWise.EduWise.core.domain.entities.StudentEnrollment;

import java.util.List;

public interface GetAllStudentEnrollmentsUseCase {
    List<StudentEnrollment> execute();
}
