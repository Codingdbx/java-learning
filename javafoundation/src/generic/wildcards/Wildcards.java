package generic.wildcards;

import java.util.List;

/**
 * 通配符
 *
 * created by dbx on 2019/3/19
 */
public class Wildcards {

    //上限有界的通配符
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    //无界的通配符
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    //较低的有界通配符
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
