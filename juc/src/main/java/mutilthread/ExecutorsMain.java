package mutilthread;

import java.util.concurrent.*;

/**
 * 几种线程池构造方法
 * created by dbx on 2019/1/12
 */
public class ExecutorsMain {

//    newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//    newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//    newScheduledThreadPool 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
//    newSingleThreadExecutor 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

//    另外有两种提交方式
//    有两种提交任务的方式：Executor.execute() 和 ExecutorService.submit()
//    通过Executor.execute()方法提交的任务，必须实现Runnable接口，该方式提交的任务不能获取返回值，因此无法判断任务是否执行成功。
//    通过ExecutorService.submit()方法提交的任务，可以获取任务执行完的返回值。
    public static void main(String[] args) {

        /**
         * newCachedThreadPool() 创建一个可缓存的线程池。
         *
         * 1.如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程。
         * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
         * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        Future<Object> submit = cachedThreadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return new Object();
            }
        });

        /**
         * newFixedThreadPool(10) 创建一个定长线程池。
         *
         *1.每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         *2.线程池的大小一旦达到最大值就会保持不变，超出的线程会在队列中等待。
         *3.如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);


        /**
         * newScheduledThreadPool(10) 创建一个定长线程池，可以定时或周期性的执行任务
         *
         * 任务是单线程方式执行，一旦一个任务失败其他任务也受影响
         */
        ScheduledExecutorService scheduledThreadPool =Executors.newScheduledThreadPool(10);

        /**
         * newSingleThreadExecutor() 创建一个使用单个 worker 线程的 Executor。
         *
         * 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
         * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
         * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        /**
         * ThreadPoolExecutor 阿里巴巴开发手册中指明了建议使用这种方式创建线程池。而不建议使用Executors。
         *
         * //corePoolSize     核心线程池大小
         * //maximumPoolSize  最大线程池大小
         * //keepAliveTime    最大存活时间
         * //unit             keepAliveTime时间单位
         * //workQueue        阻塞队列
         * //ThreadFactory       线程工厂
         * //RejectedExecutionHandler  线程池达到maximumPoolSize时，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 50, 30,
                TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


    }
}
