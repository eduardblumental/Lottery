package lv.helloit.eduards.lottery.exceptions;

import lombok.Data;
import lv.helloit.eduards.lottery.enums.ResponseStatus;

@Data
public class ApplicationError {
    private ResponseStatus status;
    private String reason;
}