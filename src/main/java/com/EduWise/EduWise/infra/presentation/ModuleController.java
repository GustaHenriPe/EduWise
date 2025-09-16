package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.usecases.module.*;
import com.EduWise.EduWise.infra.dtos.module.ModuleRequest;
import com.EduWise.EduWise.infra.dtos.module.ModuleResponse;
import com.EduWise.EduWise.infra.mappers.module.ModuleRequestResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ModuleResponse> createModule(@Valid @RequestBody ModuleRequest request) {
        var module = mapper.toDomain(request);
        var createdModule = createModuleUseCase.execute(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(createdModule));
    }

    @GetMapping()
    public ResponseEntity<List<ModuleResponse>> getAllModules() {
        List<ModuleResponse> modules = getAllModulesUseCase.execute().stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(modules);
    }

    @GetMapping("{id}")
    public ResponseEntity<ModuleResponse> getModuleById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(getModuleByIdUseCase.execute(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ModuleResponse> updateModule(@PathVariable Long id, @Valid @RequestBody ModuleRequest request) {
        var updatedModule = updateModuleUseCase.execute(id, mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(updatedModule));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        deleteModuleUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
