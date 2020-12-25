package com.codingdong.socket;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * <p>Description: InetAddress 的使用 </p>
 *
 * @author dbx
 * @date 2020/11/4 22:28
 * @since JDK1.8
 */
public class InetAddressTest {

    public static void main(String[] args) throws Exception {
        //获取本机inetAddress对象
        InetAddress address = InetAddress.getLocalHost();

        System.out.println("计算机名： " + address.getHostName());
        System.out.println("IP地址： " + address.getHostAddress());

        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP： " + Arrays.toString(bytes));
        System.out.println(address);

        //获取指定IP或者名称的inetAddress对象
        InetAddress address2 = InetAddress.getByName("115.196.153.44");
        System.out.println("计算机名： " + address2.getHostName());
        System.out.println("IP地址： " + address2.getHostAddress());
    }
}
