package com.EduWise.EduWise.infra.dtos.student_enrollment;

import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(
        @NotNull(message = "Student ID cannot be null")
        Long studentId,
        @NotNull(message = "Course ID cannot be null")
        Long courseId
) {
}
