package com.paris.dream.pojo;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;

/**
 * POJO类主要作用：SQL映射（输入/输出）映射，通常与数据库表对应。
 */
public class User {
    private Integer id;

    private String username;

    private String password;

    private Double account;

    /*
    必须提供无参构造函数，否则会报以下错误：
    org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException:
    Error instantiating class com.paris.dream.pojo.User with invalid types () or values ().
    Cause: java.lang.NoSuchMethodException: com.paris.dream.pojo.User.<init>()
     */
    private User(){
    }
    public User(Integer id, String username, String password, double account) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}