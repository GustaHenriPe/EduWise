package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.core.gateway.UserGateway;

import java.util.Optional;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private final UserGateway gateway;

    public GetUserByIdUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public User execute(Long id) {
        return gateway.getUserById(id);
    }
}
