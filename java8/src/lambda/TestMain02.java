package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description:  行为参数化</p>
 *
 * @author dbx
 * @since 2021/4/23 16:27
 */
public class TestMain02 {
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
    public interface ApplePredicate{
        boolean test (Apple apple);
    }

    /**
     * 仅仅选出重的苹果
     */
    public static class AppleHeavyWeightPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
    }

    /**
     * 仅仅选出绿苹果
     */
    public static class AppleGreenColorPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "green".equals(apple.getColor());
        }
    }

    public static class AppleRedAndHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }

    /**
     * 行为参数化
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){//谓词对象封装了测试苹果的条件
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *  prettyPrintApple 方法的一个粗略的框架
     */
//    public static void prettyPrintApple(List<Apple> inventory, ???){
//        for(Apple apple: inventory) {
//            String output = ???.???(apple);
//            System.out.println(output);
//        }
//    }


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));


        /**
         * 已经把行为抽象出来了，让你的代码适应需求的变化。
         */
        List<Apple> redAndHeavyApples0 = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> redAndHeavyApples1 = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> redAndHeavyApples2 = filterApples(inventory, new AppleRedAndHeavyPredicate());

        /**
         * 匿名类，它可以让你同时声明和实例化一个类。它可以帮助你进一步改善代码，让它变得更简洁。
         */

        //直接内联参数化 filterApples 方法的行为
        List<Apple> redApples0 = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple){
                return "red".equals(apple.getColor());
            }
        });

        //使用Lambda表达式,适用只有一个抽象方法的接口
        List<Apple> redApples1 = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));


    }

}
