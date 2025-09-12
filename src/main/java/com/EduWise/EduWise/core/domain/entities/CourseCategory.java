package com.EduWise.EduWise.core.domain.entities;

import java.time.LocalDateTime;

public record CourseCategory(
        Long id,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public CourseCategory(String title) {
        this(null, title, null, null);
    }
}
