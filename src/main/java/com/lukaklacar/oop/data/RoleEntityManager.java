package com.lukaklacar.oop.data;

import com.lukaklacar.oop.model.Role;

public class RoleEntityManager extends EntityManager<Role> {

    @Override
    public String[] serialize(Role entity) {
        return new String[]{
                entity.getId(),
                entity.getName()
        };
    }

    @Override
    public Role deserialize(String[] tokens) {
        return Role
                .builder()
                .id(tokens[0])
                .name(tokens[1])
                .build();
    }
}
