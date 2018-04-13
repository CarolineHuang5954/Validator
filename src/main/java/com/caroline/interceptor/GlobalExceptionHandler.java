package com.caroline.interceptor;

import com.caroline.Entity.Result;
import com.caroline.Entity.User;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Description: 通过全局异常处理切面方式截获Exception返回错误信息
 * @Author: Huang XinMiao
 * @Date：create in 15:40 2018/4/12
 * @Modified By:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result beanValidation(Exception exception){

        Result result = new Result();
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException)exception;
            User req = (User) e.getBindingResult().getTarget();
            final List<String> errors = e.getBindingResult().getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(toList());
            return new Result("01", errors.toString());
        }
        return new Result("-99", "未知异常");
    }
}