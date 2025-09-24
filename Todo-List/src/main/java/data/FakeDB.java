package data;

import java.util.ArrayList;
import java.util.List;
import model.Todo;

public class FakeDB {

    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo("Estudiar Java", "Repasar servlets y JSP", "Pendiente", "2025-09-25"));
        todoList.add(new Todo("Hacer ejercicio", "Salir a correr", "Completado", "2025-09-23"));
    }

    public static List<Todo> getTodoList() {
        return todoList;
    }

    public static void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public static Todo getTodoById(int id) {
        for (Todo t : todoList) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public static void updateTodo(Todo updated) {
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getId() == updated.getId()) {
                todoList.set(i, updated);
                return;
            }
        }
    }

    public static void deleteTodo(int id) {
        todoList.removeIf(t -> t.getId() == id);
    }

    private static int currentId = 1;

    public static int generateUniqueId() {
        return currentId++;
    }
}
