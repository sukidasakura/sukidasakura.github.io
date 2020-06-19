package com.supconit;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2019年12月06日 15:00
 */
public class WriteFile {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/mashencai/newTemp.txt";
        String content = "new append!";
        File destFile = new File(fileName);

        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                // 2.OutputStreamWriter向文件写入内容
                //按方法A追加文件
                appendMethodA(fileName, content);
                appendMethodA(fileName, "append end. \n");
            }
        }, 1000, 5000);
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     */
    private static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
