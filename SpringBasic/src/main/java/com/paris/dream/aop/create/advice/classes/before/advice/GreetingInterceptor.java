package com.paris.dream.aop.create.advice.classes.before.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 * Created by Sydney on 2018/5/16.
 */
public class GreetingInterceptor implements MethodInterceptor {
    // 1、截获目标类方法的执行，并在前后添加横切逻辑
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments(); //目标方法入参
        String clientName = (String)args[0];

        // 2、在目标方法执行前调用
        System.out.println("How are u! Mr." + clientName + ".");
        // 3、通过反射机制调用目标方法
        Object object = invocation.proceed();

        // 4、在目标方法执行后调用
        System.out.println("please enjoy yourself!");
        return object;
    }
}
