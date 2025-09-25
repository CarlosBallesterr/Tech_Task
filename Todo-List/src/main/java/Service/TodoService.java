package Service;

import Repository.ITodoRepository;
import data.FakeDB;
import java.util.List;
import model.Todo;

public class TodoService {
    private final ITodoRepository _repository;

    public TodoService(ITodoRepository repository) {
        this._repository = repository;
    }
        
    public List<Todo> getAllTodo(){
        return _repository.getAll();
    }
            
    public Todo getTodoById (int id) {
        return _repository.getById(id);
    }
    
    public void addTodo(Todo todo) {
        _repository.add(todo);
    }
       
    public void updateTodo(Todo todo){
        _repository.update(todo);
    }
    
    public void deleteTodo(int id){
        _repository.delete(id);
        
    }
}