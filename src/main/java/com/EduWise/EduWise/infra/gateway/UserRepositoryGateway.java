package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.entities.User;
import com.EduWise.EduWise.core.gateway.UserGateway;
import com.EduWise.EduWise.infra.mappers.user.UserEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import com.EduWise.EduWise.infra.persistence.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    @Override
    public User createUser(User user) {
        UserEntity savedUser = userRepository.save(mapper.toEntity(user));
        return mapper.toDomain(savedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public User getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        return mapper.toDomain(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));

        existingUser.setName(user.name());
        existingUser.setEmail(user.email());
        existingUser.setPasswordHash(user.passwordHash());
        existingUser.setRole(user.role());
        UserEntity updatedUser = userRepository.save(existingUser);
        return mapper.toDomain(updatedUser);

    }

    @Override
    public void deleteUser(Long id) {
    UserEntity existingUser = verifyUserById(id);
        userRepository.delete(existingUser);
    }

    public UserEntity verifyUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
    }
}
