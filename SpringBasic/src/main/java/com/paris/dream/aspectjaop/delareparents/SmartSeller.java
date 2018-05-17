package com.paris.dream.aspectjaop.delareparents;

/**
 * Created by Sydney on 2018/5/17.
 */
public class SmartSeller implements Seller{
    public void sell(String name) {
        System.out.println("sell to " + name +"...");
    }
}
