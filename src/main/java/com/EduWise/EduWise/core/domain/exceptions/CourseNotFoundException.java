package com.EduWise.EduWise.core.domain.exceptions;

public class CourseNotFoundException extends EntityNotFoundException{

    public CourseNotFoundException(Long id) {
        super("Course", id);
    }
}
