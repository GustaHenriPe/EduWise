package com.EduWise.EduWise.infra.dtos.course_category;

import jakarta.validation.constraints.NotNull;

public record CourseCategoryRequest(
        @NotNull(message = "Title cannot be null")
        String title
) {
}
