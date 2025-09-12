package com.EduWise.EduWise.infra.dtos.course;


import jakarta.validation.constraints.NotNull;

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
