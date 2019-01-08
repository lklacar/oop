package com.lukaklacar.oop.service.impl;

import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.model.User;
import com.lukaklacar.oop.service.GenericServiceImpl;
import com.lukaklacar.oop.service.UserService;

import javax.inject.Inject;

public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    @Inject
    public UserServiceImpl(EntityManager<User> entityManager) {
        super(entityManager);
    }
}
