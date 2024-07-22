package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;


public class UpdateTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance();

    @Override
    public void execute() {
        int id = Input.getInt("수정할 Id:");
        // 해당 아이디를 가진 todo를 찾아옴.
        Todo todo = dao.getTodo(id);

        System.out.println("Todo 수정하기 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println(todo.getId());
        // 값을 입력하지 않으면 기존값, 입력하면 새로운 값으로 return
        String title = Input.getLine("제목", todo.getTitle());
        String description = Input.getLine("설명", todo.getDescription());
        Boolean done = Input.confirm("완료 여부", todo.isDone());
        // 값을 입력하지 않으면 기존값, 입력하면 새로운 값으로 return
        System.out.println("Todo 수정하기 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println();

//        찾아온 todo를 새로 복사함.
        Todo updateTodo = (Todo) todo.clone();
        // 복사해온 todo에 사용자가 넣어준 title, description, done 정보를 저장함.
        updateTodo.setTitle(title);
        updateTodo.setDescription(description);
        updateTodo.setDone(done);
//      업데이트 된 내용을 가진 todo로 리스트를 갈아끼움.
        dao.update(updateTodo);
    }
}
