package com.paris.dream.aop.first.example.cglib.dynamic.proxy;

import com.paris.dream.aop.first.example.noproxy.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 定义一个拦截器，实现MethodInterceptor
 * Created by Sydney on 2018/5/16.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz); // 1.设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create(); // 2.通过字节码技术动态创建子类实例
    }

    /**
     * 重写方法拦截父类所有方法的调用，在方法前和方法后加入业务
     * Object o 为目标对象
     * Method method 为目标方法
     * Object[] params 为参数值列表
     * MethodProxy methodProxy 生成的代理类对方法的代理引用
     */
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {

        // 3.1 监视性能的横切逻辑：调用前
        PerformanceMonitor.begin(o.getClass().getName()+"."+method.getName());

        // 3.2 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, params);

        // 3.1监视性能的横切逻辑：调用后
        PerformanceMonitor.end();
        return result;
    }
}
