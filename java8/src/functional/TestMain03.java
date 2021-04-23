package functional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @since 2021/4/23 17:33
 */
public class TestMain03 {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("str0", "str1", "");

        /**
         * Predicate<T>
         * 接口定义了一个名叫test的抽象方法，它接受泛型T对象，并返回一个boolean。在你需要表示一个涉及类型T的布尔表达式时，就可以使用这个接口。
         */

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);


        /**
         *  Consumer<T>
         *  定义了一个名叫accept的抽象方法，它接受泛型T的对象，没有返回（void）。你如果需要访问类型T的对象，并对其执行某些操作，就可以使用这个接口。
         *
         */
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) ->
                System.out.println(i)    //←─Lambda是Consumer中accept方法的实现
        );

        /**
         * Function<T, R>
         * 接口定义了一个叫作apply的方法，它接受一个泛型T的对象，并返回一个泛型R的对象。如果你需要定义一个Lambda，
         * 将输入对象的信息映射到输出，就可以使用这个接口（比如提取苹果的重量，或把字符串映射为它的长度）。
         */
        // [7, 2, 6]
        List<Integer> list = map(Arrays.asList("lambdas","in","action"),
                (String s) -> s.length()    //←─Lambda是Function接口的apply方法的实现
        );

    }



}
