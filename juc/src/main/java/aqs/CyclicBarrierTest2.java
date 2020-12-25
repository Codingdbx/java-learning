package aqs;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/10/9 14:23
 * @since JDK1.8
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2,new A());//优先执行barrierAction


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

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}

