package org.scoula.lib.cli;

import org.scoula.lib.cli.ui.Menu;
import org.scoula.todo.command.Command;

public abstract class App {

    private Menu menu;

    public App() {
        menu = new Menu();
        createMenu(menu);
    }

    protected abstract void createMenu(Menu menu);

    protected void init() {
        // 필요한 초기화 작업 수행
    }

    public void run() {
        init();

        while(true) {
            try {
                menu.show();  // 메뉴를 출력
                Command command = menu.getSelect(); // 사용자로부터 선택받은 명령어 가져오기
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
