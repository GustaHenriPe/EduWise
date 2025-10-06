package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.infra.dtos.course.CourseRequest;
import com.EduWise.EduWise.infra.dtos.course.CourseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Course", description = "Endpoints for managing courses")
public interface CourseApi {
    @Operation(summary = "Create a new course", description = "Creates a new course with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Course created successfully", content = @Content(schema = @Schema(implementation = CourseResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<CourseResponse> createCourse(
            @Parameter(description = "Course data to create", required = true) CourseRequest request);

    @Operation(summary = "Get all courses", description = "Retrieves a list of all courses.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of courses", content = @Content(schema = @Schema(implementation = CourseResponse.class)))
    })
    ResponseEntity<List<CourseResponse>> getAllCourses();

    @Operation(summary = "Get course by ID", description = "Retrieves a course by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Course found", content = @Content(schema = @Schema(implementation = CourseResponse.class))),
        @ApiResponse(responseCode = "404", description = "Course not found", content = @Content)
    })
    ResponseEntity<CourseResponse> getCourseById(
            @Parameter(description = "ID of the course to retrieve", required = true) Long id);

    @Operation(summary = "Update course", description = "Updates an existing course by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Course updated successfully", content = @Content(schema = @Schema(implementation = CourseResponse.class))),
        @ApiResponse(responseCode = "404", description = "Course not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<CourseResponse> updateCourse(
            @Parameter(description = "ID of the course to update", required = true) Long id,
            @Parameter(description = "Updated course data", required = true) CourseRequest request);

    @Operation(summary = "Delete course", description = "Deletes a course by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Course deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Course not found", content = @Content)
    })
    ResponseEntity<Void> deleteCourse(
            @Parameter(description = "ID of the course to delete", required = true) Long id);
}
