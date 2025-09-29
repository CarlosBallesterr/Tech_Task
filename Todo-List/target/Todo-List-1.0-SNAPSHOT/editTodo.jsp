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
            <a href="SvTodo" class="logo">To-do App</a>    
        </div>
        <div>
            <h2>Edit To-do</h2>
            <a href="SvTodo">
                <button type="button" class="backButton">Back</button>
            </a>
            <div>
                <%
                    model.Todo todo = (model.Todo) request.getAttribute("todo");
                %>
                <form action="SvEditTodo" method="POST">
                    <input type="hidden" name="id" value="<%=todo.getId()%>">
                    <p>
                        <label>Title: </label> 
                        <input type="text" name="title" value="<%=todo.getTitle()%>" required minlength="3"> 
                    </p>
                    <p>
                        <label>Description: </label> 
                        <input type="text" name="description" value="<%=todo.getDescription()%>" required minlength="5"> 
                    </p>
                    <p>
                        <label>Status: </label>
                        <select name="status" required>
                            <option value="Pending" <%= "Pending".equals(todo.getStatus()) ? "selected" : ""%>>Pending</option>
                            <option value="Complete" <%= "Complete".equals(todo.getStatus()) ? "selected" : ""%>>Complete</option>
                        </select>
                    </p>
                    <p>
                        <label>Target Date: </label> 
                        <input type="date" name="date" value="<%=todo.getDate()%>" > 
                    </p>
                    <button type="submit">Update and Save</button>   
                </form>
            </div>
        </div>
    </body>
</html>
