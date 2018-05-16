package com.paris.dream.aop.first.example.cglib.dynamic.proxy;


import com.paris.dream.aop.first.example.jdk.dynamic.proxy.ForumServiceImpl;

/**
 * Created by Sydney on 2018/5/16.
 */
public class TestForumService {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        // 通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
