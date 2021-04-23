package functional;

/**
 * <p>Description: 函数式接口</p>
 *
 * @author dbx
 * @since 2021/4/23 17:09
 */
public class TestMain01 {

    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World 1");    ///←─使用Lambda

        Runnable r2 = new Runnable(){   // ←─使用匿名类
            public void run(){
                System.out.println("Hello World 2");
            }
        };

        process(r1);   // ←─打印“Hello World 1”
        process(r2);    //←─打印“Hello World 2”
        process(() -> System.out.println("Hello World 3"));   // ←─利用直接传递的Lambda打印“Hello World 3”
    }
}
