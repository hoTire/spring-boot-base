package com.googlecode.hotire.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(BaseException.class)
    public void handleError(BaseException exception) {
        log.error("BaseException : " + exception.getMessage());
        if (exception.getCause() != null) log.error("Cause : " + exception.getCause().toString());
        throw exception;
    }

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFound(NotFoundException ignore) {
        throw ignore;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void handleBadRequest(MethodArgumentTypeMismatchException ignore) {
        throw ignore;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleBadRequest(IllegalArgumentException ignore) {
       return getModelAndView(HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        log.error("Exception : " + exception.getMessage());
        if (exception.getCause() != null) log.error("Cause : " + exception.getCause().toString());
        return getModelAndView(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ModelAndView getModelAndView(HttpStatus status) {
        ModelAndView mv = new ModelAndView("/error/" + status.value());
        log.info(mv.getViewName());
        return mv;
    }
}
