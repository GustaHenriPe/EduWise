package com.EduWise.EduWise.infra.dtos.course;

import java.time.LocalDateTime;

public record CourseResponse(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long teacherId,
        String teacherName,
        String teacherEmail,
        String categoryTitle
) {

}