package com.paris.dream.spring.bean.lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Sydney on 2018/5/14.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    // ①接口方法：在实例化Bean前进行调用
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor() == null){
                System.out.println("调用BeanPostProcessor.postProcess BeforeInitialization()，" +
                        "color为空，设置为默认黑色。");
                        car.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed() >= 200){
                System.out.println("调用BeanPostProcessor.postProcess AfterInitialization()，" +
                        "将maxSpeed调整为200。");
                        car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
