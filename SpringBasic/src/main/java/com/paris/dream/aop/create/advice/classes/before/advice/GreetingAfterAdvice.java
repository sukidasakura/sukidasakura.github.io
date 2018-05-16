package com.paris.dream.aop.create.advice.classes.before.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Sydney on 2018/5/16.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice{

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
