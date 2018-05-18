package com.paris.dream.service;

import com.paris.dream.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 使用Spring进行测试：
 * 使用注解的方式引入配置文件和类，然后将service接口对象注入。
 * Created by Mashencai on 2018/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:database/spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);

    @Autowired
    private UserService userService;

    @Ignore
    @Test
    public void TestAddUser() throws Exception {
        User user = userService.addUser(new User(1, "msc", "123", 1.1));
        logger.info(user.toString());
    }

    @Test
    public void TestGetUserById() throws Exception {
        User user = userService.getUserById(1);
        logger.info(user.toString());
    }

}
