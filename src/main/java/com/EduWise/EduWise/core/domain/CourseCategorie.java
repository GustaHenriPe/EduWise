package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record CourseCategorie(
        Long id,
        Long courseId,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
