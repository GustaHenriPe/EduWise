package com.EduWise.EduWise.core.domain.exceptions;

public class UserNotFoundException extends EntityNotFoundException{

    public UserNotFoundException(Long id) {
        super("User", id);
    }
}
