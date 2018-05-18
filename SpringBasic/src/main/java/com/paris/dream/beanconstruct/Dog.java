package com.paris.dream.beanconstruct;

import org.springframework.stereotype.Component;

/**
 * 用@Component声明了一个组件dog
 * Created by Mashencai on 2018/5/18.
 */
@Component("dog")
public class Dog {
    public void call() {
        System.out.println("汪汪汪...");
    }
}