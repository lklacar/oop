package com.lukaklacar.oop.cli;

import com.lukaklacar.oop.cli.action.*;
import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.model.User;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class MainMenu extends AbstractMenu {
    private SubMenu subMenu;
    private EntityManager<User> userEntityManager;

    @Inject
    public MainMenu(SubMenu subMenu, EntityManager<User> userEntityManager) {
        this.subMenu = subMenu;
        this.userEntityManager = userEntityManager;
    }

    @Override
    public List<MenuAction> getActions() {
        return Arrays.asList(
                new ExitAction("Exit"),
                new PrintTextAction("Print text"),
                new DisplaySubMenuAction("Submenu", subMenu),
                new CreateEntityAction<>("Create user", userEntityManager)
        );
    }

    @Override
    public String getTitle() {
        return "Main menu";
    }
}
