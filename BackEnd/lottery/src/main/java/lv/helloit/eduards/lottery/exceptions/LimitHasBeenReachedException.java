package lv.helloit.eduards.lottery.exceptions;

public class LimitHasBeenReachedException extends RuntimeException {
    public LimitHasBeenReachedException(String message) {
        super(message);
    }
}
