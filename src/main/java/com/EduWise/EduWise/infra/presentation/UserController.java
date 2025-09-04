package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.core.usecases.user.*;
import com.EduWise.EduWise.infra.dtos.user.UserRequest;
import com.EduWise.EduWise.infra.dtos.user.UserResponse;
import com.EduWise.EduWise.infra.mappers.user.UserRequestResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserRequestResponseMapper mapper;
    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping("register")
    public UserResponse createUser(@RequestBody UserRequest dto) {
        User savedUser = createUserUseCase.execute(mapper.toDomain(dto));
        return mapper.toResponse(savedUser);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return getAllUsersUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = getUserByIdUseCase.execute(id);
        return mapper.toResponse(user);
    }

    @PutMapping("/edit/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest dto) {
        User updatedUser = updateUserUseCase.execute(id, mapper.toDomain(dto));
        return mapper.toResponse(updatedUser);
    }
}
