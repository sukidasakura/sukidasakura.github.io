package com.paris.dream.aop.advisor.staticmethod;

/**
 * Created by Sydney on 2018/5/17.
 */
public class Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name +"...");
    }

    public void serverTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}
