package com.EduWise.EduWise.core.usecases.user;

import com.EduWise.EduWise.core.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> execute();
}
