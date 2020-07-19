package concurrency.thread;

/**
 * 继承Thread
 * created by dbx on 2019/3/21
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a mutilthread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}