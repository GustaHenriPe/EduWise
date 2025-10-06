package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.core.domain.entities.Lesson;
import com.EduWise.EduWise.infra.dtos.lesson.LessonRequest;
import com.EduWise.EduWise.infra.dtos.lesson.LessonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Lesson", description = "Endpoints for managing lessons")
public interface LessonApi {
    @Operation(summary = "Create a new lesson", description = "Creates a new lesson with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Lesson created successfully", content = @Content(schema = @Schema(implementation = LessonResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<LessonResponse> createLesson(
            @Parameter(description = "Lesson data to create", required = true) LessonRequest lessonRequest);

    @Operation(summary = "Get all lessons", description = "Retrieves a list of all lessons.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of lessons", content = @Content(schema = @Schema(implementation = LessonResponse.class)))
    })
    ResponseEntity<List<LessonResponse>> getAllLessons();

    @Operation(summary = "Get lesson by ID", description = "Retrieves a lesson by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lesson found", content = @Content(schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found", content = @Content)
    })
    ResponseEntity<Lesson> getLessonById(
            @Parameter(description = "ID of the lesson to retrieve", required = true) Long id);

    @Operation(summary = "Update lesson", description = "Updates an existing lesson by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lesson updated successfully", content = @Content(schema = @Schema(implementation = LessonResponse.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<LessonResponse> updateLesson(
            @Parameter(description = "ID of the lesson to update", required = true) Long id,
            @Parameter(description = "Updated lesson data", required = true) LessonRequest lessonRequest);

    @Operation(summary = "Delete lesson", description = "Deletes a lesson by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Lesson deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Lesson not found", content = @Content)
    })
    ResponseEntity<Void> deleteLesson(
            @Parameter(description = "ID of the lesson to delete", required = true) Long id);
}
