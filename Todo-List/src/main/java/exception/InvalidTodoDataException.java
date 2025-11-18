package exception;

public class InvalidTodoDataException extends Exception{
    public InvalidTodoDataException(){
        super("Invalid Todo data");
    }
    
    public InvalidTodoDataException(String message){
        super(message);
    }
}
