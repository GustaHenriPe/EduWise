package com.EduWise.EduWise.core.domain.entities;

import com.EduWise.EduWise.core.enums.ContentType;

import java.time.LocalDateTime;

public record Lesson(
        Long id,
        Long moduleId,
        String title,
        ContentType contentType,
        String videoUrl,
        String textContent,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Lesson(Long moduleId, String title, ContentType contentType, String videoUrl, String textContent) {
        this(null, moduleId, title, contentType, videoUrl, textContent, null, null);
    }
}
