package com.EduWise.EduWise.core.domain.exceptions;

public class LessonNotFoundException extends EntityNotFoundException {

    public LessonNotFoundException(Object id) {
        super("Lesson", id);
    }
}
