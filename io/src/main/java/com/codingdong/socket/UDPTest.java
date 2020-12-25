package com.codingdong.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <p>Description: 实现UDP的网络编程</p>
 *
 * @author dbx
 * @date 2020/11/3 15:07
 * @since JDK1.8
 */
public class UDPTest {

    @Test
    void sender(){

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            byte[] data = "你好，我是UDP".getBytes();


            InetAddress inet = InetAddress.getByName("127.0.0.1");
            //封装一个数据包
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

            socket.send(packet);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }


    }

    @Test
    void receiver() throws  Exception{

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] data = new byte[1024];

        DatagramPacket packet = new DatagramPacket(data,0,data.length);

        socket.receive(packet);

        byte[] receives = packet.getData();

        System.out.println(new String(receives, 0, receives.length));


        socket.close();

    }
}
