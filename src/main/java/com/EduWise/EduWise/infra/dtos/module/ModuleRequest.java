package com.EduWise.EduWise.infra.dtos.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request body for creating or updating a module.")
public record ModuleRequest(
        @JsonProperty(required = true)
        @NotNull(message = "Course ID cannot be null")
        Long courseId,
        @NotNull(message = "Title cannot be null")
        String title
) {
}
