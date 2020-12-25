package aqs;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Description: CountDownLatch 允许一个或多个线程等待其他线程完成操作</p>
 *
 * @author dbx
 * @date 2020/10/9 14:09
 * @since JDK1.8
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);//等待 N = 2 个线程完成

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();//计数器减1
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();//阻塞当前线程，直到N为0
        System.out.println(3);

    }
}
