package com.EduWise.EduWise.infra.dtos.module;
import jakarta.validation.constraints.NotNull;


public record ModuleRequest(
        @NotNull(message = "Course ID cannot be null")
        Long courseId,
        @NotNull(message = "Title cannot be null")
        String title
) {
}
