package com.mycompany.todo.list.servlets;

import Repository.InMemoryRepository;
import Service.TodoService;
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

    TodoService _service = new TodoService(new InMemoryRepository());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        try {
            List<Todo> todoList = _service.getAllTodo();
            request.setAttribute("todoList", todoList);            
        } catch (RepositoryException e) {           
            request.setAttribute("errorMessage", e.getMessage());
        }        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            _service.deleteTodo(id);
        } catch (TodoNotFoundException | RepositoryException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }
        response.sendRedirect("SvTodo");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
