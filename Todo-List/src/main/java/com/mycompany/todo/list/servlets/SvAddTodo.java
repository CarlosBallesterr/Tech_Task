package com.mycompany.todo.list.servlets;

import Service.TodoService;
import config.ServiceProvider;
import data.FakeDB;
import exception.InvalidTodoDataException;
import exception.RepositoryException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet(name = "SvAddTodo", urlPatterns = {"/SvAddTodo"})
public class SvAddTodo extends HttpServlet {
    
    TodoService _service = ServiceProvider.getTodoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("addNewTodo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
           
        try {
            _service.addTodo(new Todo(FakeDB.generateUniqueId(), title, description, status, date));
            response.sendRedirect("SvTodo");
        } catch (InvalidTodoDataException | RepositoryException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("addNewTodo.jsp").forward(request, response);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
