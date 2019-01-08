package com.lukaklacar.oop.cli;

import com.lukaklacar.oop.cli.action.MenuAction;

import java.util.Collections;
import java.util.List;

public class SubMenu extends AbstractMenu {
    @Override
    public List<MenuAction> getActions() {
        return Collections.emptyList();
    }

    @Override
    public String getTitle() {
        return "Sub menu";
    }
}
