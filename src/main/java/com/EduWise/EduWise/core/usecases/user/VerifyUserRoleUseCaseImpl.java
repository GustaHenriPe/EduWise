package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.enums.Roles;
import com.EduWise.EduWise.core.gateway.UserGateway;

public class VerifyUserRoleUseCaseImpl implements VerifyUserRoleUseCase {

    private final UserGateway gateway;

    public VerifyUserRoleUseCaseImpl(UserGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Roles execute(Long userId) {
        return gateway.verifyUserRole(userId);
    }
}
