package generic;

/**
 * 类型推断和通用方法
 * created by dbx on 2019/3/19
 */
public class BoxDemo {

    // 泛型方法addBox定义了一个名为U的类型参数。通常，Java编译器可以推断泛型方法调用的类型参数。
    public static <U> void addBox(U u, java.util.List<Box3<U>> boxes) {
        Box3<U> box = new Box3<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box3<U>> boxes) {
        int counter = 0;
        for (Box3<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box3<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();

        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);

        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }

}
