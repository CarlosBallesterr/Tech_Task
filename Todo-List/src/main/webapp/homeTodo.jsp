<%@page import="java.util.List"%>
<%@page import="model.Todo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>To-do List</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="header">
            <a class="logo">To-do App</a>    
        </div>     
        <div>
            <h2 class="subtitle">List of To-dos</h2>
            <a href="SvAddTodo">
                <button type="button" class="buttonAdd">Add +</button>
            </a>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Target Data</th>
                    <th>Action</th>
                </tr>

                <%
                    List<Todo> todoList = (List<Todo>) request.getAttribute("todoList");
                    if (todoList != null && !todoList.isEmpty()) {
                        for (Todo todo : todoList) {
                %>        
                <tr>
                    <td><%=todo.getTitle()%> </td>            
                    <td><%=todo.getDescription()%> </td>    
                    <td><%=todo.getStatus()%> </td>    
                    <td><%=todo.getDate()%> </td>
                    <td>
                        <form action="SvEditTodo" method="GET" style="display:inline;">
                            <input type="hidden" name="id" value="<%=todo.getId()%>">
                            <button type="submit">Edit</button>
                        </form>
                        <form action="SvTodo" method="POST" style="display:inline;">
                            <input type="hidden" name="id" value="<%=todo.getId()%>">
                            <button type="submit">Delete</button>
                        </form>
                    </td>

                </tr>
                <% }
                } else {

                %>     
                <td>There are no tasks in the list.</td>
                <%   }
                %>                
            </table>
            <div >
                <h3>holi</h3>
                <%
                    int currentPage = (int) request.getAttribute("currentPage");
                    int totalPages = (int) request.getAttribute("totalPages");
                    if (totalPages < 1) {
                        if (currentPage > 1) {
                %>
                <a href="SvTodo?page=<%=currentPage - 1%>">Previous</a>
                <%
                    }
                    for (int i = 1; i < totalPages; i++) {
                %>
                <a href="SvTodo?page=<%=i%>"
                   style="<%= (i == currentPage) ? "font-weight:bold;" : ""%>">
                    <%=i%>
                </a>

                <%
                    }
                    if (currentPage < totalPages) {
                %>
                <a href="SvTodo?page=<%=currentPage + 1%>">Next</a>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
