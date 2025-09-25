package exception;

public class TodoNotFoundException extends Exception{

    public TodoNotFoundException() {
        super("Todo not found");
    }
    
    public TodoNotFoundException(String message) {
        super(message);
    }

}
