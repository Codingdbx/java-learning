package chapter2;

import java.util.Date;
import java.util.Properties;

/**
 * Created by DBC-PC on 2018/6/14
 *
 * 测试系统属性
 */
public class Property {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis());

        Properties p=System.getProperties();//系统属性
        p.list(System.out);


        System.out.println("----Memory Usage:");
        Runtime rt=Runtime.getRuntime();
        System.out.println("Total Memory="+rt.totalMemory()+"---Free Memory="+rt.freeMemory());

    }
}
