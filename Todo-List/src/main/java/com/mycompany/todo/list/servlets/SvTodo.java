package com.mycompany.todo.list.servlets;

import Service.TodoService;
import config.ServiceProvider;
import exception.InvalidTodoDataException;
import exception.RepositoryException;
import exception.TodoNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet(name = "SvTodo", urlPatterns = {"/SvTodo"})
public class SvTodo extends HttpServlet {

    TodoService _service = ServiceProvider.getTodoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;
        int pageSize = 6;

        if (request.getParameter("page") != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        try {
            int totalTodos = _service.countTodos();
            int totalPages = (int) Math.ceil((double) totalTodos / pageSize);

            int start = (page - 1) * pageSize;

            List<Todo> todoList = _service.getTodosPaginated(start, pageSize);

            request.setAttribute("todoList", todoList);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);
        } catch (RepositoryException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }
        request.getRequestDispatcher("homeTodo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            if ("delete".equals(action)) {
                _service.deleteTodo(id);
            } else if ("update".equals(action)) {
                Todo aux = _service.getTodoById(id);
                _service.updateStatusTodo(aux);
            }
        } catch (TodoNotFoundException | RepositoryException | InvalidTodoDataException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        response.sendRedirect("SvTodo");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
