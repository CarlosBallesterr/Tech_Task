<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new To-do</title>
        <link rel="stylesheet" href="css/addNewTodoStyles.css">
    </head>
    <body>
        <div class="header">
            <a href="SvTodo" class="logo">To-do App</a>    
        </div>
        <div>
            <h2>Create To-do</h2>
            <a href="SvTodo">
                <button type="button" class="backButton">Back</button>
            </a>
            <div>
                <form action="SvAddTodo" method="POST">
                    <p>
                        <label>Title: </label> 
                        <input type="text" name="title" required minlength="3"> 
                    </p>
                    <p>
                        <label>Description: </label> 
                        <input type="text" name="description" required minlength="5"> 
                    </p>
                    <p>
                        <label>Status: </label>
                        <select name="status" required>
                            <option value="">-- Select --</option>
                            <option value="Pending">Pending</option>
                            <option value="Complete">Complete</option>
                        </select>
                    </p>

                    <p><label>Target Date: </label> 
                        <input type="date" name="date" required> 
                    </p>
                    <button type="submit" >Save</button>
                </form>
            </div>
        </div>
    </body>
</html>