package exceptions;

public class InvalidEmail extends Exception {
    public InvalidEmail(String message) {
        super(message);
    }
}
