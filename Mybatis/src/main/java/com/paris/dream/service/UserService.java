package com.paris.dream.service;

import com.paris.dream.pojo.User;

/**
 * UserService接口
 * Created by Mashencai on 2018/5/18.
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    User addUser(User user) throws Exception;

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    public User getUserById(int userId) throws Exception;
}
