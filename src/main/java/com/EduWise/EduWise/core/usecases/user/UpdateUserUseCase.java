package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;

public interface UpdateUserUseCase {
    User execute(Long id, User user);
}
