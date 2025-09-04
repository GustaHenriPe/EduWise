package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.Module;

import java.util.Optional;

public interface GetModuleByIdUseCase {
    Module execute(Long id);
}
