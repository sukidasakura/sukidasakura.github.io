package com.paris.dream.aspectjaop.simpleexample;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 用AspectJ注解定义的切面：
 * 1. 在类定义处，标注了一个@AspectJ注解，通过该注解判断其是否为一个切面
 * 2. 该处注解提供两个信息：
 *      @Before 注解表示该增强是前置增强，而成员值是一个@ApsectJ切点表达式
 *      它的意思是：在目标类的greetTo()方法上织入增强，greetTo()方法可以带任意的入参和任意的返回值
 * 3. beforeGreeting方法时增强所使用的横切逻辑，该横切逻辑在目标方法前调用。
 * 现在，PreGreetingAspect一个类就相当于是BeforeAdvice、NameMatchMethodPointcut、
 * 以及DefaultPointcutAdvisor三者联合表达的信息。
 * Created by Sydney on 2018/5/17.
 */

@Aspect // 1.通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect {
    @Before("execution(*greetTo(..))") // 2.定义切点和增强类型
    public void beforeGreeting(){ // 3.增强的横切逻辑
        System.out.println("How are you");
    }
}
