package com.paris.dream.aspectjaop.simpleexample;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 通过编程的方式织入切面
 * Created by Sydney on 2018/5/17.
 */
public class AspectJProxyTest {
    public static void main(String[] args) {
        Waiter target = new NativeWaiter();
        // 通过AspectJProxyFactory织入基于接口描述的切面
        AspectJProxyFactory factory = new AspectJProxyFactory();

        // 1.设置目标对象：需要织入切面的对象
        factory.setTarget(target);
        // 2.添加一个带@AspectJ注解的类
        factory.addAspect(PreGreetingAspect.class);
        // 3.获取织入了切面的代理对象
        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");
        proxy.serverTo("John");
    }
}
