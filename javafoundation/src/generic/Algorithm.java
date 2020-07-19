package generic;

import java.util.Collection;

/**
 * 问题和练习：泛型
 *
 * 编写一个通用方法来计算集合中具有特定属性的元素数（例如，奇数整数，素数，回文数）。
 * created by dbx on 2019/3/19
 */
public class Algorithm {

    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {

        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
}
