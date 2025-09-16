package com.EduWise.EduWise.infra.dtos.module;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;


public record ModuleRequest(
        @JsonProperty(required = true)
        @NotNull(message = "Course ID cannot be null")
        Long courseId,
        @NotNull(message = "Title cannot be null")
        String title
) {
}
