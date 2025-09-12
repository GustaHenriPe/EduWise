
package com.EduWise.EduWise.infra.mappers.user;

import com.EduWise.EduWise.core.domain.entities.User;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();
        entity.setName(domain.name());
        entity.setEmail(domain.email());
        entity.setPasswordHash(domain.passwordHash());
        entity.setRole(domain.role());
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

