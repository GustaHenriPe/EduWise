package com.EduWise.EduWise.infra.dtos.user;

import com.EduWise.EduWise.core.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRequest(
        @NotNull(message = "Name cannot be null")
        String name,
        @Email(message = "Email should be valid")
        @NotNull(message = "Email cannot be null")
        String email,
        @NotNull(message = "Password hash cannot be null")
        String passwordHash,
        @NotNull(message = "Role cannot be null")
        Roles role
) {
}
