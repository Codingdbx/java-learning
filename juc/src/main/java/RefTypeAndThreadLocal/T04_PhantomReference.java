package RefTypeAndThreadLocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: 虚引用</p>
 * 1.跟没有一样，直接内存
 * @author dbx
 * @date 2020/11/6 22:19
 * @since JDK1.8
 */
public class T04_PhantomReference {

    private static List<Object> list = new LinkedList<>();

    //队列
    private static ReferenceQueue<M> queue = new ReferenceQueue<>();

    public static void main(String[] args) throws Exception {

        PhantomReference<M> reference = new PhantomReference<>(new M(), queue);

        System.out.println(reference.get());

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    list.add(new byte[1024 * 1024]);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(reference.get());
                }

            }
        }).start();

        //垃圾回收线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Reference<? extends M> poll = queue.poll();

                    if (poll != null) {

                        System.out.println("虚引用对象被jvm回收了-----" + poll);
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
