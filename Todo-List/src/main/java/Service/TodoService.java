package Service;

import Repository.ITodoRepository;
import data.FakeDB;
import exception.InvalidTodoDataException;
import exception.RepositoryException;
import exception.TodoNotFoundException;
import java.util.List;
import model.Todo;

public class TodoService {

    private final ITodoRepository _repository;

    public TodoService(ITodoRepository repository) {
        this._repository = repository;
    }

    public List<Todo> getAllTodo() throws RepositoryException{
        try {
            return _repository.getAll();
        } catch (Exception e) {
            throw new RepositoryException("Failed to fetch todos", e);
        }        
    }

    public Todo getTodoById(int id) throws TodoNotFoundException, RepositoryException{
        try {
            Todo todo = _repository.getById(id);
            if(todo == null) throw new TodoNotFoundException("Todo with Id: "+id+" not found");
            return todo;
        } catch (TodoNotFoundException e) {
            throw e;
        } catch (Exception e){
            throw new RepositoryException("Failed to fetch todo", e);
        }
        
    }

    public void addTodo(Todo todo) throws InvalidTodoDataException, RepositoryException{
        if(todo == null || todo.getTitle() == null || todo.getTitle().isEmpty())
            throw new InvalidTodoDataException("Todo title is required");
        
        try {
            _repository.add(todo);
        } catch (Exception e) {
            throw new RepositoryException("Failed to add todo", e);
        }        
    }

    public void updateTodo(Todo todo) throws TodoNotFoundException, InvalidTodoDataException, RepositoryException {
        if (todo == null || todo.getId() <= 0)
            throw new InvalidTodoDataException("Todo Id is invalid");        

        try {
            Todo existing = _repository.getById(todo.getId());
            if (existing == null) throw new TodoNotFoundException("Todo with ID: " + todo.getId() + " not found");
            _repository.update(todo);
        } catch (TodoNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RepositoryException("Failed to update todo", e);
        }      
    }

    public void deleteTodo(int id) throws TodoNotFoundException, RepositoryException{
        try {
            Todo existing = _repository.getById(id);
            if (existing == null) throw new TodoNotFoundException("Todo with ID: " + id + " not found");
            _repository.delete(id);
        } catch (TodoNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RepositoryException("Failed to delete todo", e);
        }                        
    }
    
    public int countTodos() throws RepositoryException {
        return _repository.count();
    }
    
    public List<Todo> getTodosPaginated(int start, int pageSize) throws RepositoryException {
        return _repository.findPaginated(start, pageSize);
    }
}
