package com.paris.dream.spring.beans;

import com.paris.dream.java.reflect.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 通过XmlBeanFactory实现类启动Spring IoC容器
 * Created by Sydney on 2018/5/11.
 */
public class BeanFactoryTest {
    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource(
                "file:E:/Git/sukidasakura.github.io/SpringBasic/src/main/java/com/paris/dream/spring/beans/car-beans.xml");
        // classpath:com/paris/dream/spring/beans/car-beans.xml报错
        // XmlBeanFactory通过Resource装载Spring配置信息并启动IoC容器
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init BeanFactory.");

        Car car = bf.getBean("car1", Car.class);
        System.out.println("car bean is already for use!");

    }
}
