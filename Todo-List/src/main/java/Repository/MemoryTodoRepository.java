package Repository;

import data.FakeDB;
import java.util.List;
import model.Todo;

public class MemoryTodoRepository implements TodoRepository{

    @Override
    public List<Todo> getAll() {
        return FakeDB.getTodoList();
    }

    @Override
    public Todo getById(int id) {
        return FakeDB.getTodoById(id);
    }

    @Override
    public void add(Todo todo) {
        FakeDB.addTodo(todo);
    }

    @Override
    public void update(Todo todo) {
        FakeDB.updateTodo(todo);
    }

    @Override
    public void delete(int id) {
        FakeDB.deleteTodo(id);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Todo> findPaginated(int start, int pageSize) {
        List<Todo> todo = null;
        return todo;
    }
    
}
