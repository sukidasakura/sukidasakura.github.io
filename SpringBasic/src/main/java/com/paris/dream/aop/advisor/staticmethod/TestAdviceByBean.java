package com.paris.dream.aop.advisor.staticmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过ProxyFactoryBean（xml）配置代理的测试
 * Created by Sydney on 2018/5/16.
 */
public class TestAdviceByBean {

    public static void main(String[] args) {
        // 配置文件放在resources目录
        String configPath = "classpath:com.paris.dream.aop/advisor/static-method-pointcut-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serverTo("John");
        seller.greetTo("John");
    }
}
