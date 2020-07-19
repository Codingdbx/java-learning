package language.operators;

/**
 * <p>Description: java 中的进制表示方法</p>
 *
 * @author dbx
 * @date 2020/3/22 11:14
 * @since JDK1.8
 */
public class Binary {

    int bit = 0b11; //声明二进制变量

    int ebit = 011; //声明八进制变量

    int tbit = 11; //声明十进制变量

    int sbit = 0x11; //声明十六进制变量


    public static void main(String[] args) {
        int a = 0b11111111111111111111111111111011;
        System.out.println("a="+a);

        int b = -5;
        System.out.println("b=" + Integer.toBinaryString(b));
    }

}
