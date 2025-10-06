package com.EduWise.EduWise.infra.dtos.student_enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;


@Schema(description = "Request body for creating or updating a student enrollment.")
public record EnrollmentRequest(
        @JsonProperty(required = true)
        @NotNull(message = "Student ID cannot be null")
        Long studentId,
        @JsonProperty(required = true)
        @NotNull(message = "Course ID cannot be null")
        Long courseId
) {
}
