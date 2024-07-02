package org.scoula.lib.cli.ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menus;

    public Menu() {
        menus = new ArrayList<>();
    }

    public void add(MenuItem menuItem) {
        menus.add(menuItem);
    }

    public void show() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getName());
        }
    }

    public void execute(int index) {
        if (index < 1 || index > menus.size()) {
            System.out.println("Invalid menu selection");
        } else {
            menus.get(index - 1).execute();
        }
    }
}
