package com.paris.dream;

import java.awt.image.BufferedImage;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class StringSeparation {
    public static void main(String[] args) {
        String resolution = "80x80";
        String[] re = resolution.split("x");
        int weight = Integer.parseInt(re[0]);
        int height = Integer.parseInt(re[1]);
        System.out.println(weight);
        System.out.println(height);



    }
}
