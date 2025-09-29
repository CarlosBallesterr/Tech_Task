package config;

import Repository.InMemoryRepository;
import Repository.TodoRepository;
import Service.TodoService;

public class ServiceProvider {

    private static TodoService todoService;

    public static TodoService getTodoService() {
        if (todoService == null) {
            todoService = new TodoService(new TodoRepository());
        }
        return todoService;
    }
}
