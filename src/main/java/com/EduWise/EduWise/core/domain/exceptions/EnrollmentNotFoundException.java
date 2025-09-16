package com.EduWise.EduWise.core.domain.exceptions;

public class EnrollmentNotFoundException extends EntityNotFoundException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment", id);
    }
}
