package com.EduWise.EduWise.infra.dtos.user;

import com.EduWise.EduWise.core.enums.Roles;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRequest(
        Long id,
        String name,
        String email,
        String passwordHash,
        Roles role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
