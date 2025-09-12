package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.entities.User;

public interface GetUserByIdUseCase {
    User execute(Long id);
}
