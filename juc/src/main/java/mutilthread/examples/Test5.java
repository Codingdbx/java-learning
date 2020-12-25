package mutilthread.examples;

import java.util.concurrent.*;

/**
 * created by dbx on 2019/1/4
 */
public class Test5 {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();

        // 总数据条数
        int dataSize = 5000;

        // 每5条数据开启一条线程
        int threadSize = 5;

        // 线程数
        int threadNum = dataSize / threadSize;

        System.out.println("开启" + threadNum + "个线程...");

        ExecutorService pool = new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // 分割成多个线程执行
        for (int i = 0; i < threadNum; i++) {
            //放到线程池中，线程异步执行
            pool.execute(new Thread() {
                @Override
                public void run() {
                    try {
                        //模拟业务处理数据的时间
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        pool.shutdown();

        while (true) {
            if (pool.isTerminated()) {
                break;
            }
        }

        Long end = System.currentTimeMillis();

        System.out.println("总共花费了===========" + (end - start) / 1000 + "." + (end - start) % 1000 + "s");
    }
}
