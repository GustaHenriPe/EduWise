
package com.EduWise.EduWise.infra.mappers.user;

import com.EduWise.EduWise.core.domain.User;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();
        entity.setId(domain.id());
        entity.setName(domain.name());
        entity.setEmail(domain.email());
        entity.setPasswordHash(domain.passwordHash());
        entity.setRole(domain.role());
        entity.setCreatedAt(domain.createdAt());
        entity.setUpdatedAt(domain.updatedAt());
        return entity;
    }

    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

