package com.EduWise.EduWise.infra.dtos.user;

import com.EduWise.EduWise.core.enums.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserRequest(
        @JsonProperty(required = true)
        @NotNull(message = "Name cannot be null")
        String name,

        @JsonProperty(required = true)
        @Email(message = "Email should be valid")
        @NotNull(message = "Email cannot be null")
        String email,

        @JsonProperty(required = true)
        @NotNull(message = "Password hash cannot be null")
        String passwordHash,

        @JsonProperty(required = true)
        @NotNull(message = "Role cannot be null")
        Roles role
) {
}
