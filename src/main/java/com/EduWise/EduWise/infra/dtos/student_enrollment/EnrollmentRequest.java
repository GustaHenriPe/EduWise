package com.EduWise.EduWise.infra.dtos.student_enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(
        @JsonProperty(required = true)
        @NotNull(message = "Student ID cannot be null")
        Long studentId,
        @JsonProperty(required = true)
        @NotNull(message = "Course ID cannot be null")
        Long courseId
) {
}
