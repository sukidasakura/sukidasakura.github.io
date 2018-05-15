package com.paris.dream.spring.bean.lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by Sydney on 2018/5/14.
 */
public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {

    //①接口方法：在实例化Bean前进行调用
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
            throws BeansException {
        //①-1仅对容器中car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor. postProcess" +
                    "BeforeInstantiation");
        }
        return null;
    }

    //②接口方法：在实例化Bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        //②-1仅对容器中car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor.postProcess " +
                    "AfterInstantiation");
        }
        return true;
    }

    //③接口方法：在设置某个属性时调用
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {

        //③-1仅对容器中car Bean进行处理，还可以通过pdst入参进行过滤，
        //仅对car的某个特定属性时进行处理。
        if("car".equals(beanName)){
            System.out.println("Instantiation AwareBeanPostProcessor.postProcess " +
                    "PropertyValues");
        }
        return pvs;
    }
}
