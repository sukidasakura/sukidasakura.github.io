package com.paris.dream.aop.first.example.jdk.dynamic.proxy;

import com.paris.dream.aop.first.example.noproxy.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 从业务中移除的性能监视横切代码
 * 在构造函数里通过target传入希望被代理的目标对象，如2所示
 * 在接口方法invoke中，将目标实例传给method.invoke()方法，调用目标实例的方法。
 * Created by Sydney on 2018/5/16.
 */
public class PerformanceHandler implements InvocationHandler{ // 1-实现InvocationHandler

    private Object target;
    public PerformanceHandler(Object target){ // 2-target为目标的业务类
        this.target = target;
    }

    // 实现InvocationHandler接口必须实现该方法

    /**
     * @param proxy 最终生成的代理实例，一般不会用到
     * @param method 被代理目标实例的某个具体方法，通过它可以发起目标实例方法的反射调用
     * @param args 传给被代理实例某一个方法的入参数组，在方法反射调用时使用
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());

        // 3-2通过反射调用业务类的目标方法
        Object obj = method.invoke(target, args);

        PerformanceMonitor.end();
        return null;
    }
}
