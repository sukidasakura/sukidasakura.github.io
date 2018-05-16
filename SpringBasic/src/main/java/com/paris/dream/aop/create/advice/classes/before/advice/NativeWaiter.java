package com.paris.dream.aop.create.advice.classes.before.advice;

/**
 * 需要对其使用代理的类：
 * 一个训练不足的服务生的实例
 * 只是简单向顾客打招呼，闷不做声走到顾客跟前，直接提供服务。
 * Created by Sydney on 2018/5/16.
 */
public class NativeWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("greet to " + name +"...");
    }

    public void serverTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}
