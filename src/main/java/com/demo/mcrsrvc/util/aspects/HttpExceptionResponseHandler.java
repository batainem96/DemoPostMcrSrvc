package com.demo.mcrsrvc.util.aspects;

import com.demo.mcrsrvc.util.exceptions.DuplicateRecordException;
import com.demo.mcrsrvc.util.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HttpExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public final ResponseEntity<?> handleInvalidRequestException(Exception e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public final ResponseEntity<?> handleDuplicateRecordException(Exception e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.CONFLICT);
    }

}
