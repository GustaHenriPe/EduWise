package com.EduWise.EduWise.infra.dtos.course_category;

import java.time.LocalDateTime;

public record CourseCategoryResponse(
        Long id,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
