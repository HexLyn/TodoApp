package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

// 2. 상세 클래스
public class DetailTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance();

    @Override
    public void execute() {
        int id = Input.getInt("Todo Id: ");
//        사용자에게 아이디를 입력받는다.

        Todo todo = dao.getTodo(id);
//        사용자가 입력한 아이디에 맞는 todo를 가져온다.

//        todo상세보기
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
