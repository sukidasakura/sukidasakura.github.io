package com.paris.dream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("D:/Test/2.jpg"));
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("width is : " + width);
            System.out.println("height is : " + height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
