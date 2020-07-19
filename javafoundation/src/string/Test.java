package string;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/4/3 14:59
 * @since JDK1.8
 */
public class Test {
    /**
     * 使用String直接赋值
     */
    static void test1(){
        String str = "abc";
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str==str1);//true
        System.out.println(str==str2);//true
    }

    /**
     * 使用new String 创建字符串
     */
    static void test2(){
        String str = new String("abc");
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str==str1);//false
        System.out.println(str==str2);//false
        System.out.println(str1==str2);//false
    }

    /**
     * 使用String拼接字符串
     */
    static void test3(){
        String str = "abc";//在常量池中创建abc
        String str1 = "abcd";//在常量池中创建abcd
        String str2 = str+"d";//拼接字符串，此时会在堆中新建一个abcd的对象，因为str2编译之前是未知的
        String str3 = "abc"+"d";//拼接之后str3还是abcd，所以还是会指向字符串常量池的内存地址

        System.out.println(str1==str2);//false
        System.out.println(str1==str3);//true

    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
}
