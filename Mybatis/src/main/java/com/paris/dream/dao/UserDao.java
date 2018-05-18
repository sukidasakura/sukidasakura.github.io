package com.paris.dream.dao;

import com.paris.dream.pojo.User;

import java.util.List;

/**
 * UserDao：Java对象，获得SqlSession，执行SQL语句，得到映射结果。
 */
public interface UserDao {
    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;

    /**
     * 修改用戶
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(int id) throws Exception;

    /**
     * 刪除用戶
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUserById(int id) throws Exception;

    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */
    public List<User> selectAllUser() throws Exception;
}