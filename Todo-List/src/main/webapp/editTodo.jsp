<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit To-do</title>
        <link rel="stylesheet" href="css/addNewTodoStyles.css">
    </head>
    <body>
        <div class="header">
            <a href="index.jsp" class="logo">To-do App</a>    
        </div>
        <div>
            <h2>Create To-do</h2>
            <a href="index.jsp">
                <button type="button" class="backButton">Back</button>
            </a>
            <div>
                <form action="SvEditTodo" method="POST">
                    <%
                        model.Todo todo = (model.Todo) request.getAttribute("todo");
                    %>
                    <form action="SvEditTodo" method="POST">
                        <input type="hidden" name="id" value="<%=todo.getId()%>">
                        <p><label>Title: </label> <input type="text" name="title" value="<%=todo.getTitle()%>" > </p>
                        <p><label>Description: </label> <input type="text" name="description" value="<%=todo.getDescription()%>" > </p>
                        <p>
                            <label>Status: </label>
                            <select name="status">
                                <option value="Pending" <%= "Pending".equals(todo.getStatus()) ? "selected" : ""%>>Pending</option>
                                <option value="Complete" <%= "Complete".equals(todo.getStatus()) ? "selected" : ""%>>Complete</option>
                            </select>
                        </p>
                        <p><label>Target Date: </label> <input type="date" name="date" value="<%=todo.getDate()%>" > </p>
                        <button type="submit">Update and Save</button>
                    </form>

                </form>
            </div>
        </div>
    </body>
</html>
