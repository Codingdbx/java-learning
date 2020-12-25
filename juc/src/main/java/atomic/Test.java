package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/10/26 12:13
 * @since JDK1.8
 */
public class Test {

    public static void main(String[] args) {

        AtomicInteger atomic = new AtomicInteger(0);
        int i = atomic.get();
        boolean b = atomic.compareAndSet(i, 5);


    }
}
