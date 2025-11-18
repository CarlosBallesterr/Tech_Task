public class TodoQueries {
    String GET_ALL = "SELECT * FROM todos";
    String GET_BY_ID = "SELECT * FROM todos WHERE id = ?";
    String INSERT = "INSERT INTO todos (title, description, status, date) VALUES (?, ?, ?, ?)";
    String UPDATE = "UPDATE todos SET title = ?, description = ?, status = ?, date = ? WHERE id = ?";
    String DELETE = "DELETE FROM todos WHERE id = ?";
}
