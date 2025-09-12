package com.EduWise.EduWise.infra.mappers.module;

import com.EduWise.EduWise.core.domain.Module;
import com.EduWise.EduWise.infra.dtos.module.ModuleRequest;
import com.EduWise.EduWise.infra.dtos.module.ModuleResponse;
import org.springframework.stereotype.Component;

@Component
public class ModuleRequestResponseMapper {

    public Module toDomain(ModuleRequest moduleRequest) {
        return new Module(
                moduleRequest.courseId(),
                moduleRequest.title()
        );
    }

    public ModuleResponse toResponse(Module module) {
        return new ModuleResponse(
                module.id(),
                module.courseId(),
                module.title(),
                module.createdAt(),
                module.updatedAt()
        );
    }
}
