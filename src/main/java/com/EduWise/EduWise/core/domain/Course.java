package com.EduWise.EduWise.core.domain;

import java.time.LocalDateTime;

public record Course(
        Long id,
        Long teacherId,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Course(Long id, Long teacherId, String title, String description) {
        this(id, teacherId, title, description, LocalDateTime.now(), LocalDateTime.now());
    }
}