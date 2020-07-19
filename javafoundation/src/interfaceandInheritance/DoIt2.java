package interfaceandInheritance;

/**
 * 扩展接口的默认方法
 * created by dbx on 2019/3/9
 */
public interface DoIt2 {

    void doSomething(int i, double x);
    int doSomethingElse(String s);

    //默认方法，必须提供其具体实现
    default boolean didItWork(int i, double x, String s) {
        // Method body
        return true;
    }

}
