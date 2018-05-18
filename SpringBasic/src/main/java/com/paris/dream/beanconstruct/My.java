package com.paris.dream.beanconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 声明一个组件My，使用了组件Dog，不过组建扫描默认是不启动的，
 * 所以我们要配置一下Spring，让它去寻找含有注解@Respository的类，然后为他们创建Bean。
 * Created by Mashencai on 2018/5/18.
 */
@Component("my")
public class My {
    @Autowired(required=true)
    private Dog dog;

    public void shout(){
        dog.call();
    }
}