package com.EduWise.EduWise.core.usecases.studentenrollment;

import com.EduWise.EduWise.core.domain.StudentEnrollment;

import java.util.List;

public interface GetAllStudentEnrollmentsUseCase {
    List<StudentEnrollment> execute();
}
