package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>Description: 将List类型抽象化</p>
 *
 * @author dbx
 * @since 2021/4/23 16:44
 */
public class TestMain03 {
    public static class Apple {
        private String color;
        private Integer weight;

        public Apple(Integer weight,String color){
            this.color = color;
            this.weight = weight;
        }

        String getColor() {
            return color;
        }

        Integer getWeight() {
            return weight;
        }

    }


    /**
     * 谓词-行为,只有一个抽象方法的接口
     */
    public interface Predicate<T>{
        boolean test (T t);
        default boolean test2 (T t){
            return false;
        }
    }

    /**
     * 引入类型参数T
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Integer> numbers = Arrays.asList(12,15,20);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);



    }
}
