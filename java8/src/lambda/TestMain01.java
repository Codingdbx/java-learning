package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 原始写法</p>
 *
 * @author dbx
 * @since 2021/4/23 16:13
 */
public class TestMain01 {

    public static class Apple {
        private String color;
        private Integer weight;

        public Apple(String color,Integer weight){
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
     * 筛选绿苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if( "green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 把颜色作为参数
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                  String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ( apple.getColor().equals(color) ) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 把重量作为参数
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory,
                                                   int weight) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if ( apple.getWeight() > weight ){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 把颜色和重量作为参数
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ( (flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight) ){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green", 150));
        inventory.add(new Apple("red", 100));

        List<Apple> apples0 = filterGreenApples(inventory);

        List<Apple> apples1 = filterApplesByColor(inventory, "green");
        List<Apple> apples2 = filterApplesByColor(inventory, "red");

        List<Apple> apples3 = filterApplesByWeight(inventory, 120);

        List<Apple> apples4 = filterApples(inventory, "red",120,true);



    }

}
