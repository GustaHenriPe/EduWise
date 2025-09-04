package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.gateway.ModuleGateway;

public class DeleteModuleUseCaseImpl implements DeleteModuleUseCase {

    private final ModuleGateway gateway;

    public DeleteModuleUseCaseImpl(ModuleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteModule(id);
    }
}
