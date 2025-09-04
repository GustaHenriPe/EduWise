package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.Module;

import java.util.List;

public interface GetAllModulesUseCase {
    List<Module> execute();
}
