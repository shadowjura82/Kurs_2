package com.second.kurs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceedAmountItemsException extends RuntimeException {
    public ExceedAmountItemsException(String message) {
        super(message);
        System.out.println(message);
    }
}
