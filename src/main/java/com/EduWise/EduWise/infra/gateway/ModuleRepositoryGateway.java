package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleRepositoryGateway implements ModuleGateway {
    @Override
    public Module createModule(Module module) {
        return null;
    }

    @Override
    public List<Module> getAllModules() {
        return List.of();
    }

    @Override
    public Module getModuleById(Long id) {
        return null;
    }

    @Override
    public Module updateModule(Long id, Module module) {
        return null;
    }

    @Override
    public void deleteModule(Long id) {
    }
}

