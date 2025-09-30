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
                            <input type="hidden" name="action" value="delete">
                            <button type="submit">Delete</button>
                        </form>
                        <form action="SvTodo" method="POST" style="display:inline;">
                            <input type="hidden" name="id" value="<%=todo.getId()%>">
                            <input type="hidden" name="action" value="update">
                            <button type="submit">Update</button>
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

            <div class="pagination-container">
                   <ul class="pagination">
                    <%
                        Integer currentPage = (Integer) request.getAttribute("currentPage");
                        Integer totalPages = (Integer) request.getAttribute("totalPages");

                        if (currentPage != null && totalPages != null && totalPages > 1) {
                            for (int i = 1; i <= totalPages; i++) {
                    %>
                    <li class="page-item <%= (i == currentPage) ? "active" : ""%>">
                        <a href="SvTodo?page=<%=i%>"><%=i%></a>
                    </li>
                    <%
                        }
                    %>                    
                           <% }%>
                       </ul>
            </div>
        </div>
    </body>
</html>
