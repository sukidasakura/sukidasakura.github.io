package com.paris.dream.aop.create.advice.classes.before.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 需要使用的增强：
 * 对NativeWaiter的服务行为进行规范，让他们在打招呼和提供服务之前，必须先对顾客使用礼貌用语。
 * Created by Sydney on 2018/5/16.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{

    /**
     * 在目标类方法调用前执行
     * @param method 目标类的方法
     * @param args 目标类方法的入参
     * @param target 目标类实例
     * @throws Throwable 该方法异常时，将阻止目标类方法的执行
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String clientName = (String)args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
