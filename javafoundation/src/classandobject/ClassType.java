package classandobject;


/**
 * java中类分为5中类型
 * created by dbx on 2019/10/7
 */
public class ClassType {

    class InnerClass{

    }

    static class NestedClass{

    }

    private void test(){

        class LocalClass{

        }

        new Thread(){
            public void run(){
                System.out.println("new Thread");
            }
        };

        new Thread(() -> {
            System.out.println("new Thread");
        });
    }


}
