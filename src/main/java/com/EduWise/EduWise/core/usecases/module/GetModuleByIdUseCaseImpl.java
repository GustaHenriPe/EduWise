package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.entities.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;

public class GetModuleByIdUseCaseImpl implements GetModuleByIdUseCase {

    private final ModuleGateway gateway;

    public GetModuleByIdUseCaseImpl(ModuleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Module execute(Long id) {
        return gateway.getModuleById(id);
    }
}
