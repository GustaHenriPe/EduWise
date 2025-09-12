package com.EduWise.EduWise.infra.dtos.module;

import java.time.LocalDateTime;

public record ModuleResponse(
        Long id,
        Long courseId,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
