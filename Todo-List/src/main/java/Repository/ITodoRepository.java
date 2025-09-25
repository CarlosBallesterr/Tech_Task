package Repository;

import java.util.List;
import model.Todo;

public interface ITodoRepository {
    List<Todo> getAll();
    Todo getById(int id);
    void add(Todo todo);
    void update(Todo todo);
    void delete(int id);
}
