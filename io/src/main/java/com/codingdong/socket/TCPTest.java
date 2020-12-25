package com.codingdong.socket;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>Description: 实现TCP的网络编程,发送一条消息</p>
 *
 * @author dbx
 * @date 2020/11/2 22:05
 * @since JDK1.8
 */
public class TCPTest {

    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            os = socket.getOutputStream();
            os.write("你好，我是客户端MM".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }

    @Test
    public void server(){

        ServerSocket server = null;
        Socket accept = null;//会阻塞
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("服务端启动了.....");

            accept = server.accept();

            is = accept.getInputStream();

//        byte[] bytes = new byte[5];//会有中文乱码的出现
//        int len;
//        while ((len = is.read(bytes))!= -1) {
//            System.out.println(new String(bytes,0,len));
//        }

            baos = new ByteArrayOutputStream();

            int len ;
            byte[] bytes = new byte[5];
            while ((len = is.read(bytes))!= -1) {
                baos.write(bytes, 0, len);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }
}
