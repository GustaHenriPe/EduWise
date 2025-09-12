package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.entities.StudentEnrollment;

import java.util.List;

public interface StudentEnrollmentGateway {

    StudentEnrollment createStudentEnrollment(StudentEnrollment studentEnrollment);

    List<StudentEnrollment> getAllStudentEnrollments();

    StudentEnrollment getStudentEnrollmentById(Long enrollmentId);

    StudentEnrollment updateStudentEnrollment(Long id, StudentEnrollment enrollment);

    void deleteStudentEnrollment(Long enrollmentId);
}
