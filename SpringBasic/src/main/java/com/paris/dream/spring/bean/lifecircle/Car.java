package com.paris.dream.spring.bean.lifecircle;

import org.springframework.beans.factory.*;

/**
 * 管理bean生命周期的接口
 * Created by Sydney on 2018/5/14.
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean,
        DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()构造函数");
    }

    public void setBrand(String brand){
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("brand:" + brand + "color:" + color + ";maxSpeed:"
                + maxSpeed);
    }

    // BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory){
        System.out.println("调用BeanFactoryAware.setBeanFactory()。");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware接口方法
    public void setBeanName(String beanName){
        System.out.println("调用BeanNameAware.setBeanName()。");
        this.beanName = beanName;
    }

    // DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()。");
    }

    // initializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用initializingBean.afterPropertiesSet()。");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240。");
        this.maxSpeed = 240;
    }

    // 通过<bean>的destory-method属性指定的销毁方法
    public void myDestroy(){
        System.out.println("调用destory-method所指定的myDestory()。");
    }
}
