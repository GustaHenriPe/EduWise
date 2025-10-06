package com.EduWise.EduWise.infra.dtos.course;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;


@Schema(description = "Request body for creating or updating a course.")
public record CourseRequest(
        @NotNull(message = "Teacher ID cannot be null")
        Long teacherId,
        @NotNull(message = "Category ID cannot be null")
        Long categoryId,
        @NotNull(message = "Title cannot be null")
        String title,
        @NotNull(message = "Description cannot be null")
        String description
) {
}
