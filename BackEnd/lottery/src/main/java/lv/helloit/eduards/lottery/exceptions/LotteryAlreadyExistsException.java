package lv.helloit.eduards.lottery.exceptions;

public class LotteryAlreadyExistsException extends RuntimeException{

    public LotteryAlreadyExistsException(String message) {
        super(message);
    }

}
