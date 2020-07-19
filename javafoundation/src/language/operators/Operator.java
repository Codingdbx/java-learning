package language.operators;

/**
 * 运算符
 * <p>
 * 位运算符
 * * 按位运算 & 符执行按位与运算。
 * * 按位运算 ^ 符执行按位异或运算。
 * * 按位运算  |  符执行按位包含或运算。
 * * 按位运算 ~ 符执行按位包含非运算。
 * <p>
 * 移位运算符
 * * <<  左移
 * * >>  右移
 * * >>> 无符号右移
 * <p>
 * 类型比较运算符
 * * instanceof  比较对象指定的类型
 * <p>
 * <p>
 * Created by DBC-PC on 2018/10/10
 */
public class Operator {

    public static void main(String[] args) {

        int bitmask = 0x000F;//16进制  0000000000001111
        int val = 0x2222;//16进制  000010001000100010

        // prints "2"
        System.out.println(val & bitmask);

//      计算结果：2
//      分析：0x000F转换为2进制为：0000000000001111，0x2222转换为2进制为：000010001000100010，
//      两个做位与运算为：0000000000000010，即2。

        //字符参与位运算
        char char_a = 1, char_b = 1;

        System.out.println(char_a & char_b);// 字符按ascii码中顺序参与运算
        System.out.println(8 & 9);

        test1();
        test2();
        test3();


    }

    /**
     * 1.位运算符
     * 与 或 非 异或 & | ~ ^
     */
    private static void test1() {
        /* java是有符号位:计算机最高位同时表示图号，0为正数，1为负数 */
        /* 计算机内部表示数的字节单位是定长的，如8位，16位，或32位。*/

//      1．与运算符
//      与运算符用符号“&”表示，其使用规律如下：
//      两个操作数中位都为1，结果才为1，否则结果为0，例如下面的程序段。
        int a = 129;
        int b = 128;
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("b=" + Integer.toBinaryString(b));

        System.out.println("a 和 b 与的结果是：" + (a & b));

//      运行结果 128
//      下面分析这个程序：“a”的值是129，转换成二进制就是00000000000000000000000010000001，而“b”的值是128，转换成二进制就是00000000000000000000000010000000。
//      根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是00000000000000000000000010000000，即128。


//      2．或运算符
//      或运算符用符号“|”表示，其运算规律如下：
//      两个位只要有一个为1，那么结果就是1，否则就为0，下面看一个简单的例子。
        System.out.println("a 和b 或的结果是：" + (a | b));

//      运行结果 129
//      下面分析这个程序段：a 的值是129，转换成二进制就是10000001，而b 的值是128，转换成二进制就是10000000，
//      根据或运算符的运算规律，只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。

//      3．非运算符
//      非运算符用符号“~”表示，其运算规律如下：
//      如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。
        System.out.println("a 非的结果是：" + (~a));

//      运行结果：-130
//      下面分析这个程序段：a 的值是129，转换成二进制就是00000000000000000000000010000001（省略的16位也都是0），
//      非运算后就是11111111111111111111111101111110，为负数（java是有符号位）。
//      就需要先取反(00000000000000000000000010000001)
//      再补码(00000000000000000000000010000010)再换算:-130。

//      4．异或运算符
//      异或运算符是用符号“^”表示的，其运算规律是：
//      两个操作数的位中，相同则结果为0，不同则结果为1。下面看一个简单的例子。
        System.out.println("a 与 b 异或的结果是：" + (a ^ b));

//      运行结果 a 与 b 异或的结果是：1
//      分析上面的程序段：a 的值是129，转换成二进制为10000001，而b 的值是128，转换成二进制为10000000，
//      根据异或的运算规律，可以得出其结果为00000001即1。
    }

    /**
     * 2.移位运算符
     * 移位运算符  >>  <<  >>>
     */
    private static void test2() {
        //左移运算符 <<
        System.out.println("左移运算开始------------低位补0");
        int i = 100;
        System.out.println("初始值" + i + "----" + Integer.toBinaryString(i));

        i = i << 1;
        System.out.println("左移1运算后" + i + "----" + Integer.toBinaryString(i));
        i = i << 1;
        System.out.println("左移2运算后" + i + "----" + Integer.toBinaryString(i));
        i = i << 1;
        System.out.println("左移3运算后" + i + "----" + Integer.toBinaryString(i));

        //右移运算符 >>
        System.out.println("\n\n右移运算开始------------正数高位补0，负数高位补1");
        int j = 100;
        int g = -100;
        System.out.println("初始值" + j + "----" + Integer.toBinaryString(j));
        j >>= 1;
        System.out.println("右移1运算后" + j + "----" + Integer.toBinaryString(j));
        j >>= 1;
        System.out.println("右移2运算后" + j + "----" + Integer.toBinaryString(j));
        j >>= 1;
        System.out.println("右移3运算后" + j + "----" + Integer.toBinaryString(j));
        j >>= 1;
        System.out.println("右移4运算后" + j + "----" + Integer.toBinaryString(j));

        System.out.println("\n初始值" + g + "----" + Integer.toBinaryString(g));
        g = g >> 3;
        System.out.println("右移3运算后" + g + "----" + Integer.toBinaryString(g));


        //无符号(忽略正负号)右移位运算符 >>>
        System.out.println("\n\n无符号右移位运算开始------------无论正负高位补0");
        int k = 100;
        System.out.println("初始值" + k + "----" + Integer.toBinaryString(k));
        k >>>= 1;
        System.out.println("右移位1运算后" + k + "----" + Integer.toBinaryString(k));

    }

    /**
     * 3.一元运算符
     */
    private static void test3() {
        int i = 10;
        int j = 10;
        int n = i++ % 5;//先进行表达式运算再自+
        int m = ++j % 5;//先自+再进行表达式运算

        System.out.println(i);
        System.out.println(n);
        System.out.println(m);
    }
}
