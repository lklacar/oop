package com.lukaklacar.oop.cli;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.lukaklacar.oop.cli.action.MenuAction;

public abstract class AbstractMenu {

    public abstract List<MenuAction> getActions();

    public void display() {
        System.out.println(getTitle());
        IntStream.range(0, getActions().size()).forEach(i -> System.out.println(i + ". " + getActions().get(i).getText()));
    }

    public void waitForInput() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        getActions().get(num).execute();
    }

    public abstract String getTitle();
}
