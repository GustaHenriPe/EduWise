package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.User;
import com.EduWise.EduWise.core.usecases.user.*;
import com.EduWise.EduWise.infra.dtos.user.UserRequest;
import com.EduWise.EduWise.infra.dtos.user.UserResponse;
import com.EduWise.EduWise.infra.mappers.user.UserRequestResponseMapper;
import com.EduWise.EduWise.infra.presentation.api.UserApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users/")
public class UserController implements UserApi {

    private final UserRequestResponseMapper mapper;
    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @Override
    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        User savedUser = createUserUseCase.execute(mapper.toDomain(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedUser));
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = getAllUsersUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        User user = getUserByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(user));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        User updatedUser = updateUserUseCase.execute(id, mapper.toDomain(userRequest));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(updatedUser));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
