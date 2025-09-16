package com.EduWise.EduWise.core.domain.exceptions;

public class ModuleNotFoundException extends EntityNotFoundException{

    public ModuleNotFoundException(Long id) {
        super("Module", id);
    }
}
