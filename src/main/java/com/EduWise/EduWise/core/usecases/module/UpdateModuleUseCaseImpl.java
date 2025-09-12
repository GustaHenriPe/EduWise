package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.entities.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;

public class UpdateModuleUseCaseImpl implements UpdateModuleUseCase {

    private final ModuleGateway gateway;

    public UpdateModuleUseCaseImpl(ModuleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Module execute(Long id, Module module) {
        return gateway.updateModule(id, module);
    }
}
