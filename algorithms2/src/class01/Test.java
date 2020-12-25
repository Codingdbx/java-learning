package class01;

/**
 * <p>Description: 如何不用额外变量交换两个数</p>
 *
 * @author dbx
 * @date 2020/10/30 22:37
 * @since JDK1.8
 */
public class Test {

    public static void main(String[] args) {
        int a = 5;
        int b = 1000;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

    }
}
