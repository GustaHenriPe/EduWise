package com.EduWise.EduWise.infra.dtos.student_enrollment;

import java.time.LocalDateTime;

public record EnrollmentResponse(
        Long id,
        String nameUser,
        String nameCourse,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
