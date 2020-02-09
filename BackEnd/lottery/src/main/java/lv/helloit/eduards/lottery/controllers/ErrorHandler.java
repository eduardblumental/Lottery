package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.exceptions.ApplicationError;
import lv.helloit.eduards.lottery.exceptions.LotteryAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<ApplicationError> handleLotteryAlreadyExistsException(LotteryAlreadyExistsException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setStatus("Fail");
        error.setReason(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
