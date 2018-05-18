package com.paris.dream.aop.advisor.staticmethod;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 增强类，用于配合切面类
 * Created by Sydney on 2018/5/17.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 输出切点
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String)args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
