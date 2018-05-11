package com.paris.dream.spring.context;

import com.paris.dream.java.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过带@Configuration的配置类启动容器
 * Created by Sydney on 2018/5/11.
 */
public class AnnotationApplicationContext {
    public static void main(String[] args) {
        // 通过一个带@Configuration的POJO装载Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
    }
}
