package com.paris.dream.spring.context;

import com.paris.dream.java.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 以带注解的Java类提供的配置信息
 * Created by Sydney on 2018/5/11.
 */

// 表示是一个配置信息提供类
@Configuration
public class Beans{

    // 定义一个Bean
    @Bean(name="car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(200);
        return car;
    }

}
