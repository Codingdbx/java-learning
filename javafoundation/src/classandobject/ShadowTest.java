package classandobject;

/**
 * 阴影
 *
 * created by dbx on 2019/3/4
 */
public class ShadowTest {

    // 如果特定范围（例如内部类或方法定义）中的类型声明（例如成员变量或参数名称）与封闭范围中的另一个声明具有相同的名称，
    // 则声明将隐藏声明封闭范围。您不能仅通过其名称引用带阴影的声明。
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        FirstLevel fl = st.new FirstLevel();

        fl.methodInFirstLevel(23);
    }

}
