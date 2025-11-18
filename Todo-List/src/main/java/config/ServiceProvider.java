package config;

import Repository.MemoryTodoRepository;
import Repository.DBTodoRepository;
import Service.TodoService;

public class ServiceProvider {

    private static TodoService todoService;

    public static TodoService getTodoService() {
        if (todoService == null) {
            todoService = new TodoService(new DBTodoRepository());
        }
        return todoService;
    }
}
