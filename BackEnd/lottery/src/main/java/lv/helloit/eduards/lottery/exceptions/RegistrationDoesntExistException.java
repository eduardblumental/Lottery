package lv.helloit.eduards.lottery.exceptions;

public class RegistrationDoesntExistException extends RuntimeException {
    public RegistrationDoesntExistException(String message) {
        super(message);
    }
}
