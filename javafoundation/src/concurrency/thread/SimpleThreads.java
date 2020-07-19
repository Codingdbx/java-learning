package concurrency.thread;

/**
 * created by dbx on 2019/3/21
 */
public class SimpleThreads {

    //显示一条消息，前面带有当前线程的名称
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {

        public void run() {

            String importantInfo[] = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};

            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        //延迟，以毫秒为单位
        //我们中断MessageLoop
        //线程（默认一小时）。

        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {

            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop mutilthread");
        long startTime = System.currentTimeMillis();

        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop mutilthread to finish");

        // loop until MessageLoop
        // mutilthread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");

            // 等待最多1秒钟
            // 用于MessageLoop线程完成。

            t.join(1000);//等待 t 线程，等待时间是1000毫秒。t.join();//调用join方法，等待线程t执行完毕
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();//不能中断在运行中的线程，它只能改变中断状态而已。

                //对中断状态做些什么
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
