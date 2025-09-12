package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record Module(
        Long id,
        Long courseId,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Module(Long courseId, String title) {
        this(null, courseId, title, null, null);
    }
}
