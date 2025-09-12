package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record Course(
        Long id,
        Long teacherId,
        Long categoryId,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Course(Long teacherId, String title, String description, Long categoryId) {
        this(null, teacherId, categoryId, title, description, null, null);
    }
}