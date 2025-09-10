package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record StudentEnrollment(
        Long id,
        Long userId,
        Long courseId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public StudentEnrollment(Long id, Long userId, Long courseId) {
        this(id, userId, courseId, LocalDateTime.now(), LocalDateTime.now());
    }
}
