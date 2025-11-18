package Repository;

import java.util.List;
import model.Todo;

public interface TodoRepository {
    List<Todo> getAll();
    Todo getById(int id);
    void add(Todo todo);
    void update(Todo todo);
    void delete(int id);
    
    int count();
    List<Todo> findPaginated(int start, int pageSize);
}
