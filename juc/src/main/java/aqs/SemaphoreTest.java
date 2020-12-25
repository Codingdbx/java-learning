package aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>Description: Semaphore 信号量 用来控制并发线程数</p>
 *
 * @author dbx
 * @date 2020/10/9 14:32
 * @since JDK1.8
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);//允许最大10个许可证

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();//获取一个许可证
                        System.out.println("save data..");
                        s.release();//归还许可证
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
