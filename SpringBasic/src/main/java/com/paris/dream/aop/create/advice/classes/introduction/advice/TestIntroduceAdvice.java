package com.paris.dream.aop.create.advice.classes.introduction.advice;

import com.paris.dream.aop.first.example.jdk.dynamic.proxy.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sydney on 2018/5/16.
 */
public class TestIntroduceAdvice {
    public static void main(String[] args) {
        String configPath = "classpath:com.paris.dream.aop/create.advice.classes.introduction.advice/introduction-advice-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");

        // 默认情况下，未开启监视功能
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        // 开启监视功能
        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorActive(true);

        // 在监视功能开启的情况下，再次调用业务方法
        forumService.removeForum(10);
        forumService.removeTopic(1022);

    }


}
