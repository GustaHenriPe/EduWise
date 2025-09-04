package com.EduWise.EduWise.core.gateway;

import com.EduWise.EduWise.core.domain.User;

import java.util.List;

public interface UserGateway {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}
