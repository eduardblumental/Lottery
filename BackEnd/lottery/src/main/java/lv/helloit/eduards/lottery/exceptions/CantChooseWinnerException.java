package lv.helloit.eduards.lottery.exceptions;

public class CantChooseWinnerException extends RuntimeException {

    public CantChooseWinnerException(String message) {
        super(message);
    }

}
