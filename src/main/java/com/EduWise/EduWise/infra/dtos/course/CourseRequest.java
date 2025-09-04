package com.EduWise.EduWise.infra.dtos.course;

import java.time.LocalDateTime;


public record CourseRequest(
        Long id,
        Long teacherId,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
