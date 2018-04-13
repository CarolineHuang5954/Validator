package com.caroline.interceptor;

import com.caroline.Entity.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @Description: 通过切面获取bindingResult对象的方式返回错误信息
 * @Author: Huang XinMiao
 * @Date：create in 15:40 2018/4/12
 * @Modified By:
 */
@Aspect
@Component
public class ControllerValidationAspect {
    @Around("execution(* com.caroline.*.*(..)) && args(..,bindingResult)")
    public Result doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result = doErrorHandle(bindingResult);
        } else {
            result = (Result) pjp.proceed();
        }
        return result;
    }

    private Result doErrorHandle(BindingResult bindingResult){
        return new Result("01", bindingResult.getFieldError().getDefaultMessage());
    }
}
