package concurrency.thread;

import java.util.concurrent.Callable;

/**
 * created by dbx on 2019/1/6
 */
public class HelloCallable implements Callable<String> {

    //可以作为入参的接口
    public HelloCallable(){

        Thread.currentThread().setName("HelloCallable");
    }
    /**
     * 特点：1.具有返回值 2.可以抛出异常
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {

        return "true";
    }
}
