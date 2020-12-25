package aqs;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: Exchanger 用于线程间协作的工具类，可用于线程间交换数据。</p>
 *  提供一个同步点，在这个同步点两个线程可以交换彼此的数据。
 * @author dbx
 * @date 2020/10/9 14:40
 * @since JDK1.8
 */
public class ExchangerTest {

    private  static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                String A = "银行流水A"; //A录入银行的流水
                try {
                    String B = exgr.exchange(A);
                    System.out.println("B录入的是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                String B = "银行流水B"; //B录入银行的流水
                try {
                    String A = exgr.exchange(B);
                    System.out.println("A录入的是：" + A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
