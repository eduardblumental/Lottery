package lv.helloit.eduards.lottery.exceptions;

public class LotteryDoesntExistException extends RuntimeException {

    public LotteryDoesntExistException(String message) {
        super(message);
    }


}
