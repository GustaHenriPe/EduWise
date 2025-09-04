package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;

public interface CreateUserUseCase {
    User execute(User user);
}
