package com.EduWise.EduWise.infra.mappers.module;

import com.EduWise.EduWise.core.domain.Module;
import com.EduWise.EduWise.infra.persistence.entities.ModuleEntity;
import org.springframework.stereotype.Component;

@Component
public class ModuleEntityMapper {

    public ModuleEntity toEntity(Module domain) {
        ModuleEntity entity = new ModuleEntity();
        entity.setTitle(domain.title());
        return entity;
    }

    public Module toDomain(ModuleEntity entity) {
        return new Module(
                entity.getId(),
                entity.getCourseEntity().getId(),
                entity.getTitle(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()

        );
    }
}
