package com.googlecode.hotire.base.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@Data
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INTERNAL_SERVER_ERROR")
public class BaseException extends RuntimeException {
    private String message;
    public BaseException(String message) {
        this.message = message;
    }
}
