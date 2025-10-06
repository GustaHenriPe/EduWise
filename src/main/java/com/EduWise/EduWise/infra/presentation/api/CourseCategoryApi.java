package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryRequest;
import com.EduWise.EduWise.infra.dtos.course_category.CourseCategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Course Category", description = "Endpoints for managing course categories")
public interface CourseCategoryApi {
    @Operation(summary = "Create a new course category", description = "Creates a new course category with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Course category created successfully", content = @Content(schema = @Schema(implementation = CourseCategoryResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<CourseCategoryResponse> createCourseCategory(
            @Parameter(description = "Course category data to create", required = true) CourseCategoryRequest request);

    @Operation(summary = "Get all course categories", description = "Retrieves a list of all course categories.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of course categories", content = @Content(schema = @Schema(implementation = CourseCategoryResponse.class)))
    })
    ResponseEntity<List<CourseCategoryResponse>> getAllCourseCategories();

    @Operation(summary = "Get course category by ID", description = "Retrieves a course category by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Course category found", content = @Content(schema = @Schema(implementation = CourseCategoryResponse.class))),
        @ApiResponse(responseCode = "404", description = "Course category not found", content = @Content)
    })
    ResponseEntity<CourseCategoryResponse> getCourseCategoryById(
            @Parameter(description = "ID of the course category to retrieve", required = true) Long id);

    @Operation(summary = "Update course category", description = "Updates an existing course category by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Course category updated successfully", content = @Content(schema = @Schema(implementation = CourseCategoryResponse.class))),
        @ApiResponse(responseCode = "404", description = "Course category not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<CourseCategoryResponse> updateCourseCategory(
            @Parameter(description = "ID of the course category to update", required = true) Long id,
            @Parameter(description = "Updated course category data", required = true) CourseCategoryRequest request);

    @Operation(summary = "Delete course category", description = "Deletes a course category by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Course category deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Course category not found", content = @Content)
    })
    ResponseEntity<Void> deleteCourseCategory(
            @Parameter(description = "ID of the course category to delete", required = true) Long id);
}
