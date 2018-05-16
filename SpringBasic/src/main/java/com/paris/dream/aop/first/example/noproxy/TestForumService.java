package com.paris.dream.aop.first.example.noproxy;

/**
 * 测试拥有性能监视能力的ForumServiceImpl业务方法
 * Created by Sydney on 2018/5/16.
 */
public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
