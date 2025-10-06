package com.EduWise.EduWise.infra.dtos.course_category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;


@Schema(description = "Request body for creating or updating a course category.")
public record CourseCategoryRequest(
        @NotNull(message = "Title cannot be null")
        String title
) {
}
