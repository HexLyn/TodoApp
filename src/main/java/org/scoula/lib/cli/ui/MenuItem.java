package org.scoula.lib.cli.ui;

import org.scoula.todo.command.Command;

public class MenuItem {
    private String name;
    private Command command;

    public MenuItem(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        command.execute();
    }
}
