package org.scoula.todo.command;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

public class DetailTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance();

    @Override
    public void execute() {
        int id = Input.getInt("Todo Id: ");
        Todo todo = dao.getTodo(id);

        System.out.println("Todo 상세 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println(todo.getId());
        System.out.println(todo.getTitle());
        System.out.println(todo.getDescription());
        System.out.println(todo.isDone());
        System.out.println(todo.getRegDate());
        System.out.println("Todo 상세 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println();
    }
}
