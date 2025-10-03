package com.EduWise.EduWise.infra.dtos.lesson;

import com.EduWise.EduWise.core.enums.ContentType;

import java.time.LocalDateTime;

public record LessonResponse(
        Long id,
        String moduleTitle,
        String title,
        ContentType contentType,
        String videoUrl,
        String textContent,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
