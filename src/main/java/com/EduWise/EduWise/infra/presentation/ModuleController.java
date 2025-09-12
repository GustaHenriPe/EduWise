package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.usecases.module.*;
import com.EduWise.EduWise.infra.dtos.module.ModuleRequest;
import com.EduWise.EduWise.infra.dtos.module.ModuleResponse;
import com.EduWise.EduWise.infra.mappers.module.ModuleRequestResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/modules/")
public class ModuleController {

    private final CreateModuleUseCase createModuleUseCase;
    private final GetAllModulesUseCase getAllModulesUseCase;
    private final GetModuleByIdUseCase getModuleByIdUseCase;
    private final UpdateModuleUseCase updateModuleUseCase;
    private final DeleteModuleUseCase deleteModuleUseCase;
    private final ModuleRequestResponseMapper mapper;

    @PostMapping()
    public ModuleResponse createModule(@Valid @RequestBody ModuleRequest request) {
        var module = mapper.toDomain(request);
        var createdModule = createModuleUseCase.execute(module);
        return mapper.toResponse(createdModule);
    }

    @GetMapping()
    public List<ModuleResponse> getAllModules() {
        return getAllModulesUseCase.execute().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("{id}")
    public ModuleResponse getModuleById(@PathVariable Long id) {
        return mapper.toResponse(getModuleByIdUseCase.execute(id));
    }

    @PutMapping("{id}")
    public ModuleResponse updateModule(@PathVariable Long id, @Valid @RequestBody ModuleRequest request) {
        var updatedModule = updateModuleUseCase.execute(id, mapper.toDomain(request));
        return mapper.toResponse(updatedModule);
    }

    @DeleteMapping("{id}")
    public void deleteModule(@PathVariable Long id) {
        deleteModuleUseCase.execute(id);
    }
}
