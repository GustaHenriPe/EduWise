package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.entities.Module;

public interface GetModuleByIdUseCase {
    Module execute(Long id);
}
