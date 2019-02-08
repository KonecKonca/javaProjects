package ru.javabegin.training.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // это дял системного окна с ошибками (либо эта, либо нижняя)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "IOException )) ")
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException(Exception e){
        log.error("Global excepion handler executed", e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getStackTrace());

        return modelAndView;
    }

}
