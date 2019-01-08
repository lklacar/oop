package com.lukaklacar.oop;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lukaklacar.oop.cli.MainMenu;
import com.lukaklacar.oop.model.User;
import com.lukaklacar.oop.service.UserService;
import lombok.var;

public class Program {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new OOPModule());
        UserService userEntityManager = injector.getInstance(UserService.class);
        var allUsers = userEntityManager.findAll();
        User user = User.builder().id("2").username("TEST").build();
        userEntityManager.save(user);

        MainMenu menu = injector.getInstance(MainMenu.class);

        menu.display();
        menu.waitForInput();

    }

}
