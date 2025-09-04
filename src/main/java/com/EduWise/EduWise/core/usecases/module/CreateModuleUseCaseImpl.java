package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;

public class CreateModuleUseCaseImpl implements CreateModuleUseCase {

    private final ModuleGateway gateway;

    public CreateModuleUseCaseImpl(ModuleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Module execute(Module module) {
        return gateway.createModule(module);
    }
}
