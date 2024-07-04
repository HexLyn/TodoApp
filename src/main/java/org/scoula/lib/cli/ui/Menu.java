package org.scoula.lib.cli.ui;

import org.scoula.todo.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> menus;

    public Menu() {
        menus = new ArrayList<>();
    }

    public void add(MenuItem menuItem) {
        menus.add(menuItem);
    }

    public void printMenu() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getName());
        }
    }

    public Command getSelect() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("메뉴 선택: ");
        int index = scanner.nextInt();
        if (index < 1 || index > menus.size()) {
            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            return null;
        } else {
            return menus.get(index - 1).getCommand();
        }
    }
}
