package aqs;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>Description: CyclicBarrier 同步屏障器，让一组线程到达同步点时阻塞，直到最后一个线程到达时，屏障才会开门。</p>
 *
 *  CyclicBarrier 可以用于多线程计算，最后合并结果的场景
 * @author dbx
 * @date 2020/10/9 14:17
 * @since JDK1.8
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }
}
