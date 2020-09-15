package exceptions;

public class InvalidCarNumber extends Exception {
    public InvalidCarNumber(String message) {
        super(message);
    }
}
