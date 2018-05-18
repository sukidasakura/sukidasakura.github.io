package com.paris.dream.aop.advisor.staticmethod;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 切面类
 * 目标：在Waiter#greetTo()方法调用前织入一个增强。
 * 但另外还需要一个增强类GreetingBeforeAdvice的配合
 * Created by Sydney on 2018/5/17.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{
    // 1.切点方法匹配规则：方法名为greeTo
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    // 2.切点类匹配规则：为Waiter的类或子类
    // 这里通过覆盖getClassFilter方法，让它仅匹配Waiter类及其子类
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

}
