package cc.asac.api.exception;//package org.api.exception;

import cc.asac.api.enums.StatusCode;
import cc.asac.api.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

/**
 * @author: fox
 * @Date: 2020/4/17
 * Description:全局异常（API）
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionException extends Exception {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数异常:{}"+e.getMessage());
        String message = "参数 ["+ Objects.requireNonNull(e.getBindingResult().getFieldError()).getField()
                +"] "+Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return Result.fail(StatusCode.ERROR_PARAMETER.getCode(),message);
    }

    @ExceptionHandler(value = {ResponseStatusException.class})
    public Result<?> handle(ResponseStatusException e) {
        log.error("响应状态异常:{}", e.getMessage());
        return Result.fail(StatusCode.GATEWAY_ERROR);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<?> handle(NotFoundException e) {
        log.error("未发现资源异常:{}", e.getMessage());
        return Result.fail(StatusCode.REQUEST_NOT_FOUND);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handle(RuntimeException e) {
        log.error("运行时异常:{}", e.getMessage());
        return Result.fail(StatusCode.SYSTEM_ERR);
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exception(Exception e) {
        log.error("未捕获异常:{}"+e.getMessage());
        return Result.fail(StatusCode.NO_EXCEPTION);
    }
}
