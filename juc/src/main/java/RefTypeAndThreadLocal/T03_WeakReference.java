package RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

/**
 * <p>Description: 弱引用</p>
 *  1. 会被gc直接回收
 * @author dbx
 * @date 2020/11/6 22:17
 * @since JDK1.8
 */
public class T03_WeakReference {

    public static void main(String[] args) {

        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());
    }
}
