package com.EduWise.EduWise.infra.dtos.lesson;

import com.EduWise.EduWise.core.enums.ContentType;
import jakarta.validation.constraints.NotNull;

public record LessonRequest(
        @NotNull
        Long moduleId,
        @NotNull
        String title,
        @NotNull
        ContentType contentType,
        String videoUrl,
        String textContent
) {
}
