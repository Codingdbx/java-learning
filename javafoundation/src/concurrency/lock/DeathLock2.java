package concurrency.lock;

/**
 * <p>Description: 死锁的例子</p>
 *
 * @author dbx
 * @date 2020/3/26 11:17
 * @since JDK1.8
 */
public class DeathLock2 {

    private static class Obj1 {
    }

    private static class Obj2 {
    }

    /**
     * 线程死锁等待演示
     */
    public static class SynAddRunAble implements Runnable {
        final Obj1 obj1;
        final Obj2 obj2;
        boolean flag;

        public SynAddRunAble(Obj1 obj1, Obj2 obj2, boolean flag) {
            this.obj1 = obj1;
            this.obj2 = obj2;
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                if (flag) {
                    synchronized (obj1) {
                        Thread.sleep(100);
                        synchronized (obj2) {
                            System.out.println("test....");
                        }
                    }
                } else {
                    synchronized (obj2) {
                        Thread.sleep(100);
                        synchronized (obj1) {
                            System.out.println("test....");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Obj1 obj1 = new Obj1();
        Obj2 obj2 = new Obj2();
        Thread thread1 = new Thread(new SynAddRunAble(obj1, obj2, true));
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(new SynAddRunAble(obj1, obj2, false));
        thread2.setName("thread2");
        thread2.start();

        //thread1持有com.jvm.visualvm.Demo4$Obj1的锁，等待获取com.jvm.visualvm.Demo4$Obj2的锁
        // thread2持有com.jvm.visualvm.Demo4$Obj2的锁，等待获取com.jvm.visualvm.Demo4$Obj1的锁
        // 两个线程相互等待获取对方持有的锁，出现死锁。
    }
}

