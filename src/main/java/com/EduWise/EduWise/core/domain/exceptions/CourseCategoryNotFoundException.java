package com.EduWise.EduWise.core.domain.exceptions;

public class CourseCategoryNotFoundException extends EntityNotFoundException{

    public CourseCategoryNotFoundException(Long id) {
        super("Course Category", id);
    }
}
