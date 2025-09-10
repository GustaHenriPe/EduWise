package com.EduWise.EduWise.infra.dtos.student_enrollment;

public record EnrollmentRequest(
        Long id,
        Long studentId,
        Long courseId) {
}
