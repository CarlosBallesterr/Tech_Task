package Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Todo;
import util.DBConnection;

public class TodoRepository implements ITodoRepository {

    @Override
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();

        String sql = "SELECT * FROM todos";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setDescription(rs.getString("description"));
                todo.setStatus(rs.getString("status"));
                todo.setDate(rs.getString("date"));

                todos.add(todo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todos;
    }

    @Override
    public Todo getById(int id) {
        String sql = "SELECT * FROM todos WHERE id = ?";
        Todo todo = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setDescription(rs.getString("description"));
                todo.setStatus(rs.getString("status"));
                todo.setDate(rs.getString("date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todo;
    }

    @Override
    public void add(Todo todo) {
        String sql = "INSERT INTO todos (title, description, status, date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getStatus());
            stmt.setString(4, todo.getDate());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Todo todo) {
        String sql = "UPDATE todos SET title = ?, description = ?, status = ?, date = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getStatus());
            stmt.setString(4, todo.getDate());
            stmt.setInt(5, todo.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM todos WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count() {
        String sql = "SELECT COUNT(*) AS total FROM todos";
        int total = 0;
        
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                total= rs.getInt("total");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return total;
    }

    @Override
    public List<Todo> findPaginated(int start, int pageSize) {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos ORDER BY id LIMIT ? OFFSET ?";
        
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setInt(1, pageSize);
                stmt.setInt(2, start);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    todos.add(mapTodo(rs));
                }
                                                                   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }
    
    private Todo mapTodo(ResultSet rs) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setStatus(rs.getString("status"));
        todo.setDate(rs.getString("date"));        
        return todo; 
    }
}
