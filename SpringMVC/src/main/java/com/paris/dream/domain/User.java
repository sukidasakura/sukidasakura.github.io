package com.paris.dream.domain;

/**
 * Created by Mashencai on 2018/5/22.
 */
public class User {
    // 注意User中的参数名和register.jsp中的表单组件是相同的，这样SpringMVC即可将表单组件值填充到User相应属性中。
    private String userName;
    private String password;
    private String realName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
