package com.lukaklacar.oop.cli.action;

import com.lukaklacar.oop.cli.SubMenu;

public class DisplaySubMenuAction extends MenuAction {
    private SubMenu subMenu;

    public DisplaySubMenuAction(String text, SubMenu subMenu) {
        super(text);
        this.subMenu = subMenu;
    }

    @Override
    public void execute() {
        subMenu.display();
    }

}
