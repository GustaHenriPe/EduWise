package com.EduWise.EduWise.core.domain.entities;

import java.time.LocalDateTime;

public record StudentEnrollment(
        Long id,
        Long userId,
        Long courseId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public StudentEnrollment(Long userId, Long courseId) {
        this(null, userId, courseId, null, null);
    }
}
