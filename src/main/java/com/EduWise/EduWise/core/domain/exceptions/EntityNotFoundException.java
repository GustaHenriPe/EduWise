package com.EduWise.EduWise.core.domain.exceptions;

public class EntityNotFoundException extends DomainException {

    protected EntityNotFoundException(String entityName, Object id) {
        super(String.format("%s not found with id: %s", entityName, id));
    }
}
