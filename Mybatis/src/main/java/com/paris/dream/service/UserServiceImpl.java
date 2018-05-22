package com.paris.dream.service;

import com.paris.dream.dao.UserDao;
import com.paris.dream.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 * Created by Mashencai on 2018/5/18.
 */

@Service("userService") // 装配一个bean
public class UserServiceImpl implements UserService {

    @Resource // 注入一个bean
    private UserDao userDao;

    @Override
    public User addUser(User user) throws Exception {
        userDao.insertUser(user);
        return user;
    }

    @Override
    public User getUserById(int userId) throws Exception {
        return this.userDao.selectUserById(userId);
    }

}
