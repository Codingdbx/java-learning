package concurrency.thread;

/**
 * 集成Runnable
 * created by dbx on 2019/3/21
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a mutilthread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}

