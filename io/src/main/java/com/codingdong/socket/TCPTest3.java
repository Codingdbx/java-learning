package com.codingdong.socket;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>Description: 实现TCP的网络编程</p>
 *
 * @author dbx
 * @date 2020/11/3 14:42
 * @since JDK1.8
 */
public class TCPTest3 {


    @Test
    void client() throws Exception{
        Socket socket = new Socket("127.0.0.1",8889);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("D:\\github-myproject\\java-learning\\socket\\src\\main\\resources\\12345.jpg");

        byte[] bytes = new byte[1024];
        int len;

        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //接收服务器的响应信息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes2 = new byte[5];

        int len2 ;
        while ((len2 = is.read(bytes2))!= -1) {
            baos.write(bytes2, 0, len2);
        }

        System.out.println(baos.toString());

        socket.close();
        os.close();
        fis.close();
        is.close();
        baos.close();
    }


    @Test
    void server() throws Exception{

        ServerSocket server = new ServerSocket(8889);
        System.out.println("服务端启动了......");

        Socket accept = server.accept();

        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream("D:\\github-myproject\\java-learning\\socket\\src\\main\\resources\\12345678.jpg");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        System.out.println("写入文件成功......");

        OutputStream os = accept.getOutputStream();
        os.write("我是服务端，我已经完成写入了".getBytes());

        server.close();
        accept.close();
        is.close();
        fos.close();
        os.close();

    }
}
