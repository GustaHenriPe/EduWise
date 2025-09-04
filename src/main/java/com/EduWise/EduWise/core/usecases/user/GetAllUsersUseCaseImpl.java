package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.core.gateway.UserGateway;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserGateway gateway;

    public GetAllUsersUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<User> execute() {
        return gateway.getAllUsers();
    }
}
