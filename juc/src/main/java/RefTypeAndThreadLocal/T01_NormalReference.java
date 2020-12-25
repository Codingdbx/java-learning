package RefTypeAndThreadLocal;

/**
 * <p>Description: 强引用</p>
 * 1.不会被垃圾回收
 *
 * @author dbx
 * @date 2020/11/6 22:50
 * @since JDK1.8
 */
public class T01_NormalReference {

    public static void main(String[] args) throws Exception {

        M m = new M();//new 出来的都是强引用
        m = null;
        System.gc();

        System.out.println(m);

        System.in.read();//阻塞main线程，等待垃圾回收线程执行
    }
}
