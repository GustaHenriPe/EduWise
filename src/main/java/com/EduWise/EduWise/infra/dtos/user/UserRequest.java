package com.EduWise.EduWise.infra.dtos.user;

import com.EduWise.EduWise.core.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;


@Schema(description = "Request body for creating or updating a user.")
@Builder
public record UserRequest(
        @NotNull(message = "Name cannot be null")
        String name,

        @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid E-Mail")
        @NotNull(message = "Email cannot be null")
        String email,

        @NotNull(message = "Password hash cannot be null")
        String passwordHash,

        @NotNull(message = "Role cannot be null")
        Roles role
) {
}
