package concurrency.lock;

import java.util.concurrent.*;

/**
 * <p>Description: 饥饿死锁的例子</p>
 *
 * @author dbx
 * @date 2020/3/26 13:41
 * @since JDK1.8
 */
public class ExecutorLock {

    private static ExecutorService single = Executors.newSingleThreadExecutor();

    public static class AnotherCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("in AnotherCallable");
            return "another success";
        }
    }

    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("in MyCallable");
            Future<String> submit = single.submit(new AnotherCallable());
            return "success:" + submit.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable task = new MyCallable();
        Future<String> submit = single.submit(task);
        System.out.println(submit.get());
        System.out.println("over");
        single.shutdown();

        //可以看出主线程在36行处于等待中，线程池中的工作线程在29行处于等待中，等待获取结果。
        // 由于线程池是一个线程，AnotherCallable得不到执行，而被饿死，最终导致了程序死锁的现象。
    }
}
