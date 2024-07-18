package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

public class AddTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance();

    @Override
    public void execute() {
        System.out.println("새 Todo 추가 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        String title = Input.getLine("제목 : ", "default");
        String description = Input.getLine("설명 : ", "default");
        System.out.println("새 Todo 추가 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        // Todo.builder(). ~~~ . build();
        // 사용자에게 받아온 제목과 설명으로 새로운 할 일 생성.
        Todo todo = Todo.builder()
                .title(title)
                .description(description)
                .done(false)
                .build();
        // 생성된 것을 할일 목록에 추가한다.
        dao.add(todo);
        // dao는 TodoDao dao = TodoListDao.getInstance(); 이며
        // getInstance는 instance를 반환하고,
        // private static TodoListDao instance = new TodoListDao();
        // instance는 TodoListDao로

        System.out.println();
    }
}
