package com.codingdong.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>Description: URL网络编程</p>
 *
 * @author dbx
 * @date 2020/11/3 15:29
 * @since JDK1.8
 */
public class URLTest2 {

    public static void main(String[] args) {

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1sK41177JB?p=16");

            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("D:\\github-myproject\\java-learning\\io\\src\\main\\resources\\44.jpg");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            System.out.println("下载完成.....");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
