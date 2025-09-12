package com.EduWise.EduWise.infra.mappers.user;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.infra.dtos.user.UserRequest;
import com.EduWise.EduWise.infra.dtos.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserRequestResponseMapper {

    public User toDomain(UserRequest userRequest) {
        return new User(
                userRequest.name(),
                userRequest.email(),
                userRequest.passwordHash(),
                userRequest.role()
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.id(),
                user.name(),
                user.email(),
                user.role(),
                user.createdAt(),
                user.updatedAt()
        );
    }
}
