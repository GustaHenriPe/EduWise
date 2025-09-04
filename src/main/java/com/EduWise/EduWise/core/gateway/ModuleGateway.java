package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.Module;

import java.util.List;

public interface ModuleGateway {
    Module createModule(Module module);

    List<Module> getAllModules();

    Module getModuleById(Long id);

    Module updateModule(Long id, Module module);


    void deleteModule(Long id);


}
