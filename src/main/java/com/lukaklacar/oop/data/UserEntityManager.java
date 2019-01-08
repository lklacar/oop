package com.lukaklacar.oop.data;

import com.lukaklacar.oop.model.Role;
import com.lukaklacar.oop.model.User;

import javax.inject.Inject;
import java.util.Optional;

public class UserEntityManager extends EntityManager<User> {

    private EntityManager<Role> roleEntityManager;

    @Inject
    public UserEntityManager(EntityManager<Role> roleEntityManager) {
        this.roleEntityManager = roleEntityManager;
    }

    @Override
    public String[] serialize(User entity) {
        return new String[]{
                entity.getId(),
                entity.getUsername(),
                Optional.ofNullable(entity.getRole()).map(Role::getName).orElse(getConfig().getNullIdentifier())
        };
    }

    @Override
    public User deserialize(String[] tokens) {
        return User
                .builder()
                .id(tokens[0])
                .username(tokens[1])
                .role(roleEntityManager.findById(tokens[2]).orElse(null))
                .build();
    }
}
