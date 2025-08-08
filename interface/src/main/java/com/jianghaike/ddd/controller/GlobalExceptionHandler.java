package com.jianghaike.ddd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author jianghaike
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result handleValidException(MethodArgumentNotValidException ex, HttpServletResponse response) {
        return wrapperBindingResult(ex.getBindingResult(), response);
    }

    private Result wrapperBindingResult(BindingResult bindingResult, HttpServletResponse response) {
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            if (error instanceof FieldError) {
                errorMsg.append(((FieldError) error).getField()).append(": ");
            }
            String defaultMessage = error.getDefaultMessage();
            errorMsg.append(Objects.isNull(defaultMessage) ? "" : defaultMessage);
        }
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return Result.failure(ResultCode.PARAM_IS_INVALID.getCode(), errorMsg.toString(), null);
    }
}
