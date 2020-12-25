package com.codingdong.socket;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>Description: 实现TCP的网络编程,发送一个文件</p>
 *
 * @author dbx
 * @date 2020/11/3 14:26
 * @since JDK1.8
 */
public class TCPTest2 {

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

        socket.close();
        os.close();
        fis.close();

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
        server.close();
        accept.close();
        is.close();
        fos.close();

    }
}
