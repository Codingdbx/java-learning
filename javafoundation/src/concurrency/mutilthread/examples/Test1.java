package concurrency.mutilthread.examples;

import java.util.concurrent.*;

/**
 * created by dbx on 2019/1/4
 */
public class Test1 {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();

        // 总数据条数
        int dataSize = 5000;

        System.out.println("开启1个线程...");

        // 创建一个线程池

        //corePoolSize     核心线程池大小
        //maximumPoolSize   最大线程池大小
        //keepAliveTime    最大存活时间
        //unit          eepAliveTime时间单位
        //workQueue       阻塞队列
        ExecutorService pool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i <dataSize ; i++) {
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
        //当调用shutdown()方法后，并且所有提交的任务完成后,isTerminated()返回为true;
        pool.shutdown();

        while (true) {
            if (pool.isTerminated()) {//所有的子线程都结束了
                break;
            }
        }

        Long end = System.currentTimeMillis();

        System.out.println("总共花费了===========" + (end - start) / 1000 + "." + (end - start) % 1000 + "s");
    }
}
