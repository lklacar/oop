package com.lukaklacar.oop.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractModel {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    @Builder
    public User(String id, String username, String password, String firstName, String lastName, Role role) {
        super(id);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

}
