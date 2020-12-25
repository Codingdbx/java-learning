package RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * <p>Description: 软引用</p>
 * 1.在内存不足的时候被回收，可以用来做缓存
 * @author dbx
 * @date 2020/11/6 22:53
 * @since JDK1.8
 */
public class T02_SoftReference {

    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);

        System.out.println(m.get());

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        //再分配一个数组，heap装不下了，这时候gc会回收垃圾一下，如果不够，软引用对象会被干掉。
        byte[] bytes = new byte[1024 * 1024 * 10];

        System.out.println(m.get());

    }
}
