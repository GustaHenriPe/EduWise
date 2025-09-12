package com.EduWise.EduWise.core.usecases.module;

import com.EduWise.EduWise.core.domain.entities.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;

import java.util.List;

public class GetAllModulesUseCaseImpl implements GetAllModulesUseCase {

    private final ModuleGateway gateway;

    public GetAllModulesUseCaseImpl(ModuleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Module> execute() {
        return gateway.getAllModules();
    }
}
