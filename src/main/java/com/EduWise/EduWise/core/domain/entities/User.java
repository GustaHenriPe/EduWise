package com.EduWise.EduWise.core.domain.entities;

import com.EduWise.EduWise.core.enums.Roles;

import java.time.LocalDateTime;

public record User(
        Long id,
        String name,
        String email,
        String passwordHash,
        Roles role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public User(String name, String email, String passwordHash, Roles role) {
        this(null, name, email, passwordHash, role, null, null);
    }
}
