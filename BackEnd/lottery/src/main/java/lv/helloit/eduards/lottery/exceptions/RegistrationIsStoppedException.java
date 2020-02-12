package lv.helloit.eduards.lottery.exceptions;

public class RegistrationIsStoppedException extends RuntimeException {
    public RegistrationIsStoppedException(String message) {
        super(message);
    }
}
