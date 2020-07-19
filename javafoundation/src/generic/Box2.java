package generic;

/**
 * 泛型-通用类型
 *
 * created by dbx on 2019/3/14
 */
public class Box2<T> {
    // T stands for "Type"
    // 类型变量 T 可以是您指定的任何非基本类型、任何类类型、任何接口类型、任何数组类型，甚至是其他类型变量。
    private T t;

//    E - Element (used extensively by the Java Collections Framework)
//    K - Key
//    N - Number
//    T - Type
//    V - Value
//    S,U,V etc. - 2nd, 3rd, 4th types
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
