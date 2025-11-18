package com.mycompany.todo.list.servlets;

import Service.TodoService;
import config.ServiceProvider;
import exception.InvalidTodoDataException;
import exception.RepositoryException;
import exception.TodoNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet(name = "SvEditTodo", urlPatterns = {"/SvEditTodo"})
public class SvEditTodo extends HttpServlet {

    TodoService _service = ServiceProvider.getTodoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Todo todo = _service.getTodoById(id);
            request.setAttribute("todo", todo);
        } catch (TodoNotFoundException | RepositoryException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        request.getRequestDispatcher("editTodo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            String date = request.getParameter("date");
            
            _service.updateTodo(new Todo(id, title, description, status, date));
            response.sendRedirect("SvTodo");
        } catch (TodoNotFoundException ex) {
            Logger.getLogger(SvEditTodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidTodoDataException | RepositoryException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
