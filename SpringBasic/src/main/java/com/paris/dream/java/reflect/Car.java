package com.paris.dream.java.reflect;

/**
 * Created by Sydney on 2018/5/11.
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    // 默认构造函数
    public Car(){}

    // 带参构造函数
    public Car(String brand, String color, int maxSpeed){
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // 未带参的方法
    public void introduce(){
        System.out.println("...");
    }

    // 参数的getter/Setter方法
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
