package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.entities.Module;
import com.EduWise.EduWise.core.gateway.ModuleGateway;
import com.EduWise.EduWise.infra.mappers.module.ModuleEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import com.EduWise.EduWise.infra.persistence.entities.ModuleEntity;
import com.EduWise.EduWise.infra.persistence.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ModuleRepositoryGateway implements ModuleGateway {

    private final ModuleEntityMapper mapper;
    private final ModuleRepository moduleRepository;
    private final CourseRepositoryGateway courseGateway;

    @Override
    public Module createModule(Module module) {
        ModuleEntity moduleEntity = mapper.toEntity(module);

        CourseEntity course = courseGateway.verifyExistingCourse(module.courseId());
        moduleEntity.setCourseEntity(course);

        return mapper.toDomain(moduleRepository.save(moduleEntity));
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Module getModuleById(Long id) {
        return mapper.toDomain(verifyExistingModule(id));
    }

    @Override
    public Module updateModule(Long id, Module module) {
        ModuleEntity existingModule = verifyExistingModule(id);

        existingModule.setTitle(module.title());

        CourseEntity course = courseGateway.verifyExistingCourse(module.courseId());
        existingModule.setCourseEntity(course);

        ModuleEntity updatedModule = moduleRepository.save(existingModule);
        return mapper.toDomain(updatedModule);
    }

    @Override
    public void deleteModule(Long id) {
        ModuleEntity existingModule = verifyExistingModule(id);
        moduleRepository.delete(existingModule);
    }

    public ModuleEntity verifyExistingModule(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }
}

