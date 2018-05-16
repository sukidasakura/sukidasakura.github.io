package com.paris.dream.aop.create.advice.classes.before.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 制定好礼貌用语的前值增强，着手强制在服务生队伍中应用这个规定。
 * Created by Sydney on 2018/5/16.
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {
        Waiter target = new NativeWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // 1.Spring提供的代理工厂：内部使用jdk代理或cglib代理的技术，将增强应用到目标类中。
        ProxyFactory pf = new ProxyFactory();

        // 2.设置代理目标
        pf.setTarget(target);
        /*
        pf.setInterfaces(target.getClass().getInterfaces()); // 指定对接口进行代理
        pf.setOptimize(true); // 启用优化
        */

        // 3.为代理目标设置增强
        pf.addAdvice(advice);
        // 可以使用该方法添加多个增强，多个增强形成一个增强链。
        // 可以使用addAdvice(int, Advice)将增强添加到增强链的具体位置（第一个位置为0）

        // 4.生成代理实例
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serverTo("Tom");
    }
}
