package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.infra.dtos.module.ModuleRequest;
import com.EduWise.EduWise.infra.dtos.module.ModuleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Module", description = "Endpoints for managing modules")
public interface ModuleApi {
    @Operation(summary = "Create a new module", description = "Creates a new module with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Module created successfully", content = @Content(schema = @Schema(implementation = ModuleResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<ModuleResponse> createModule(
            @Parameter(description = "Module data to create", required = true) ModuleRequest request);

    @Operation(summary = "Get all modules", description = "Retrieves a list of all modules.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of modules", content = @Content(schema = @Schema(implementation = ModuleResponse.class)))
    })
    ResponseEntity<List<ModuleResponse>> getAllModules();

    @Operation(summary = "Get module by ID", description = "Retrieves a module by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Module found", content = @Content(schema = @Schema(implementation = ModuleResponse.class))),
        @ApiResponse(responseCode = "404", description = "Module not found", content = @Content)
    })
    ResponseEntity<ModuleResponse> getModuleById(
            @Parameter(description = "ID of the module to retrieve", required = true) Long id);

    @Operation(summary = "Update module", description = "Updates an existing module by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Module updated successfully", content = @Content(schema = @Schema(implementation = ModuleResponse.class))),
        @ApiResponse(responseCode = "404", description = "Module not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<ModuleResponse> updateModule(
            @Parameter(description = "ID of the module to update", required = true) Long id,
            @Parameter(description = "Updated module data", required = true) ModuleRequest request);

    @Operation(summary = "Delete module", description = "Deletes a module by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Module deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Module not found", content = @Content)
    })
    ResponseEntity<Void> deleteModule(
            @Parameter(description = "ID of the module to delete", required = true) Long id);
}
