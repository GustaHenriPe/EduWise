package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentRequest;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Student Enrollment", description = "Endpoints for managing student enrollments")
public interface StudentEnrollmentApi {
    @Operation(summary = "Create a new enrollment", description = "Creates a new student enrollment with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Enrollment created successfully", content = @Content(schema = @Schema(implementation = EnrollmentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<EnrollmentResponse> createEnrollment(
            @Parameter(description = "Enrollment data to create", required = true) EnrollmentRequest request);

    @Operation(summary = "Get all enrollments", description = "Retrieves a list of all student enrollments.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of enrollments", content = @Content(schema = @Schema(implementation = EnrollmentResponse.class)))
    })
    ResponseEntity<List<EnrollmentResponse>> getAllEnrollments();

    @Operation(summary = "Get enrollment by ID", description = "Retrieves a student enrollment by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Enrollment found", content = @Content(schema = @Schema(implementation = EnrollmentResponse.class))),
        @ApiResponse(responseCode = "404", description = "Enrollment not found", content = @Content)
    })
    ResponseEntity<EnrollmentResponse> getEnrollmentById(
            @Parameter(description = "ID of the enrollment to retrieve", required = true) Long id);

    @Operation(summary = "Update enrollment", description = "Updates an existing student enrollment by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Enrollment updated successfully", content = @Content(schema = @Schema(implementation = EnrollmentResponse.class))),
        @ApiResponse(responseCode = "404", description = "Enrollment not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<EnrollmentResponse> updateEnrollment(
            @Parameter(description = "ID of the enrollment to update", required = true) Long id,
            @Parameter(description = "Updated enrollment data", required = true) EnrollmentRequest request);

    @Operation(summary = "Delete enrollment", description = "Deletes a student enrollment by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Enrollment deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Enrollment not found", content = @Content)
    })
    ResponseEntity<Void> deleteEnrollment(
            @Parameter(description = "ID of the enrollment to delete", required = true) Long id);
}
