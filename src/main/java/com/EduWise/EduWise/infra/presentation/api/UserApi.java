package com.EduWise.EduWise.infra.presentation.api;

import com.EduWise.EduWise.infra.dtos.user.UserRequest;
import com.EduWise.EduWise.infra.dtos.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(name = "User", description = "Endpoints for managing users")
public interface UserApi {
    @Operation(summary = "Create a new user", description = "Creates a new user with the provided information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<UserResponse> createUser(
            @Parameter(description = "User data to create", required = true) UserRequest userRequest);

    @Operation(summary = "Get all users", description = "Retrieves a list of all users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of users", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    })
    ResponseEntity<List<UserResponse>> getAllUsers();

    @Operation(summary = "Get user by ID", description = "Retrieves a user by their unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found", content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    ResponseEntity<UserResponse> getUserById(
            @Parameter(description = "ID of the user to retrieve", required = true) Long id);

    @Operation(summary = "Update user", description = "Updates an existing user by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated successfully", content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    ResponseEntity<UserResponse> updateUser(
            @Parameter(description = "ID of the user to update", required = true) Long id,
            @Parameter(description = "Updated user data", required = true) UserRequest userRequest);

    @Operation(summary = "Delete user", description = "Deletes a user by their unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "User deleted successfully"),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    ResponseEntity<Void> deleteUser(
            @Parameter(description = "ID of the user to delete", required = true) Long id);
}
