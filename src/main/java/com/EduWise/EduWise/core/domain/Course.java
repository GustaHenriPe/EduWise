package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record Course(
        Long id,
        Long teacherId, // Use apenas o ID
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}