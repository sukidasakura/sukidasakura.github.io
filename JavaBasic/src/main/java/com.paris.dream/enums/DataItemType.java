package com.paris.dream.enums;

/**
 * Created by Sydney on 2018/5/17.
 */
public enum DataItemType {
    STATIC(0, "静态数据"), DYNAMIC(1, "动态数据"); // 1

    private int value;
    private String description;

    // 这个构造函数主要是用于1处。
    private DataItemType(int value, String description){
        this.value = value;
        this.description = description;
    }

    public int value(){
        return value;
    }

    public String description(){
        return description;
    }

    // 根据value值（此处是0和1）获取枚举类对象。
    public static DataItemType valueOf(int value){
        for (DataItemType type:DataItemType.values()) {
            if (type.value() == value){
                return type;
            }
        }
        return null;
    }


}
