package com.lukaklacar.oop;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.lukaklacar.oop.cli.MainMenu;
import com.lukaklacar.oop.cli.SubMenu;
import com.lukaklacar.oop.config.Config;
import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.data.RoleEntityManager;
import com.lukaklacar.oop.data.UserEntityManager;
import com.lukaklacar.oop.model.Role;
import com.lukaklacar.oop.model.User;
import com.lukaklacar.oop.service.UserService;
import com.lukaklacar.oop.service.impl.UserServiceImpl;

public class OOPModule extends AbstractModule {

    @Override
    protected void configure() {
        bindEntityManagers();
        bindServices();
        bindConfig();
        bindMenu();
    }

    private void bindMenu() {
        bind(MainMenu.class);
        bind(SubMenu.class);
    }

    private void bindConfig() {
        bind(Config.class).toInstance(Config
                .builder()
                .delimiter(",")
                .dataLocation("data")
                .nullIdentifier("NULL")
                .build());
    }

    private void bindServices() {
        bind(UserService.class).to(UserServiceImpl.class);
    }

    private void bindEntityManagers() {

        bind(new TypeLiteral<EntityManager<User>>() {
        }).to(UserEntityManager.class);

        bind(new TypeLiteral<EntityManager<Role>>() {
        }).to(RoleEntityManager.class);
    }

}
