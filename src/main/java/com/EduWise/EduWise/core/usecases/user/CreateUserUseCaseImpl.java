package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.entities.User;
import com.EduWise.EduWise.core.gateway.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway gateway;

    public CreateUserUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public User execute(User user) {
        return gateway.createUser(user);
    }
}
