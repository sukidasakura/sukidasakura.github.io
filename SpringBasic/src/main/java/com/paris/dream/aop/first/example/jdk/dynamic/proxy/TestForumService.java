package com.paris.dream.aop.first.example.jdk.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理只能为接口创建代理实例
 * Created by Sydney on 2018/5/16.
 */
public class TestForumService {
    public static void main(String[] args) {

        // 1.希望被代理的目标业务类
        ForumService forumService = new ForumServiceImpl();

        // 2.将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(forumService);

        // 3.根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        // 第二个参数interfaces就是需要代理实例实现的接口列表
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                forumService.getClass().getClassLoader(),
                forumService.getClass().getInterfaces(),
                handler
        );

        // 4.调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);


    }
}
