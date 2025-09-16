package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.enums.Roles;

public interface VerifyUserRoleUseCase {

    Roles execute(Long userId);
}
