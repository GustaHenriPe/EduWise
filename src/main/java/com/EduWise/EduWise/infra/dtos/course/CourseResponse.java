package com.EduWise.EduWise.infra.dtos.course;

import lombok.Builder;

import java.time.LocalDateTime;

public record CourseResponse(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long teacherId,
        String teacherName,
        String teacherEmail
) {

}