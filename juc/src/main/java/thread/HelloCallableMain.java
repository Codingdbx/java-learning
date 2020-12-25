package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * created by dbx on 2019/1/6
 */
public class HelloCallableMain {

    public static void main(String[] args) {

        HelloCallable helloCallable =new HelloCallable();

        //执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果
        FutureTask<String> future = new FutureTask<>(helloCallable);

        //启动线程
        new Thread(future).start();

        try {
            String result = future.get();

            System.out.println("结果是--"+result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
