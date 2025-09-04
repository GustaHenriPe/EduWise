package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.Module;

public interface UpdateModuleUseCase {
    Module execute(Long id, Module module);
}
