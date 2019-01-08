package com.lukaklacar.oop.cli.action;

public abstract class MenuAction {

    private String text;

    public abstract void execute();

    public MenuAction(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
