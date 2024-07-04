package org.scoula.lib.cli;

import org.scoula.lib.cli.ui.Menu;
import org.scoula.todo.command.Command;

public abstract class App {

    private Menu menu;

    public App() {
        menu = new Menu();
        createMenu(menu);
    }

    protected void createMenu(Menu menu) {
    }

    protected void init() {
        // 필요한 초기화 작업 수행
    }

    public void run() {
        init();

        while(true) {
            try {
                menu.printMenu();
                Command command = menu.getSelect();
                command.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
