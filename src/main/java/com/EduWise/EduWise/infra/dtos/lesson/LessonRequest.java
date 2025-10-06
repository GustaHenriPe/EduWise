package com.EduWise.EduWise.infra.dtos.lesson;

import com.EduWise.EduWise.core.enums.ContentType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request body for creating or updating a lesson.")
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
