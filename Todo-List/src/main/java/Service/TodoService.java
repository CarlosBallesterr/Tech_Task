package Service;

import data.FakeDB;
import java.util.List;
import model.Todo;

public class TodoService {
    
    public List<Todo> getAllTodo(){
        return FakeDB.getTodoList();
    }
        
    
    public Todo getTodoById (int id) {
        return FakeDB.getTodoById(id);
    }
    
    public Todo createTodo(String title, String description, String status, String date) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setStatus(status);
        todo.setDate(date);
        todo.setId(FakeDB.generateUniqueId());
        return todo;
    }
    
    public void addTodoList (Todo todo){
        FakeDB.addTodo(todo);
    }        
    
    public void updateTodo(int id, String title, String description, String status, String date){
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setTitle(title);
            todo.setDescription(description);
            todo.setStatus(status);
            todo.setDate(date);
        }
    }
    
    public void deleteTodo(int id){
        FakeDB.deleteTodo(id);
        
    }
}