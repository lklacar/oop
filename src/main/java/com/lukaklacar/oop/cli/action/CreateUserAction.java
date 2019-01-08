package com.lukaklacar.oop.cli.action;

import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.model.User;
import com.lukaklacar.oop.service.UserService;

import java.util.Scanner;

public class CreateUserAction extends CreateEntityAction<User> {

    private UserService userService;

    public CreateUserAction(String text, EntityManager<User> entityManager, UserService userService) {
        super(text, entityManager);
        this.userService = userService;
    }

    @Override
    public User getEntityFromConsole() {
        Scanner in = new Scanner(System.in);

        System.out.println("ID: ");
        String id = in.nextLine();

        System.out.println("Username: ");
        String username  = in.nextLine();

        System.out.println("Username: ");
        String password = in.nextLine();

    }
}
