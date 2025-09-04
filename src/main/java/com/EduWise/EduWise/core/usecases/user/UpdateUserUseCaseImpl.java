package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.core.gateway.UserGateway;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGateway gateway;

    public UpdateUserUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public User execute(Long id, User user) {
        return gateway.updateUser(id, user);
    }
}
