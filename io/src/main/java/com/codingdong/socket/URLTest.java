package com.codingdong.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>Description: URL网络编程</p>
 *
 * @author dbx
 * @date 2020/11/3 15:23
 * @since JDK1.8
 */
public class URLTest {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.bilibili.com/video/BV1sK41177JB?p=16");

            System.out.println("protocol:"+url.getProtocol());

            System.out.println("host:"+url.getHost());
            System.out.println("port:"+url.getPort());
            System.out.println("path:"+url.getPath());
            System.out.println("file:"+url.getFile());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
