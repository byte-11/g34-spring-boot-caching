package uz.bellissimo.g34springbootcaching.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException e) {
        return ErrorResponse
                .builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("Error")
                .property("timestamp", new Date())
                .build();

    }
}
