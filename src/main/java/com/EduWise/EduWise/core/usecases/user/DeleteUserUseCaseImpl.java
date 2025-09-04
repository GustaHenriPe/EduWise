package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.gateway.UserGateway;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGateway gateway;

    public DeleteUserUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(Long id) {
        gateway.deleteUser(id);
    }
}
