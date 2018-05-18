package com.paris.dream.aspectjaop.delareparents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试代码
 * Created by Sydney on 2018/5/17.
 */
public class DeclaredParentsTest {
    public static void main(String[] args) {
        String configPath = "classpath:com.paris.dream.aop/aspectjaop/aspectj-delare-parents.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller = (Seller)waiter; // 可以成功进行强制类型转换
        seller.sell("Beer");
    }
}
