package com.mycompany.todo.list.servlets;

import data.FakeDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet(name = "SvEditTodo", urlPatterns = {"/SvEditTodo"})
public class SvEditTodo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Todo todo = FakeDB.getTodoById(id);
        request.setAttribute("todo", todo);
        request.getRequestDispatcher("editTodo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        
        Todo todo = FakeDB.getTodoById(id);
        if (todo != null) {
            todo.setTitle(title);
            todo.setDescription(description);
            todo.setStatus(status);
            todo.setDate(date);
        }
       
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
