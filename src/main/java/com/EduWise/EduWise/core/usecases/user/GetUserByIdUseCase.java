package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;

import java.util.Optional;

public interface GetUserByIdUseCase {
    User execute(Long id);
}
