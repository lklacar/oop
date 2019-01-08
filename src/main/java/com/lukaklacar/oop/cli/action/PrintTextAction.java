package com.lukaklacar.oop.cli.action;

public class PrintTextAction extends MenuAction {
    public PrintTextAction(String text) {
        super(text);
    }

    @Override
    public void execute() {
        System.out.println("Print text action");
    }
}
