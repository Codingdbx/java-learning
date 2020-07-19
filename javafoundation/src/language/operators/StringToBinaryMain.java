package language.operators;

/**
 * <p>Description: 字符串转成二进制码</p>
 *
 * @author dbx
 * @date 2020/3/20 11:15
 * @since JDK1.8
 */
public class StringToBinaryMain {

    public static void main(String[] args) {
        String str = "kij1";
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + "";
        }
        System.out.println("\n\n字符串转成二进制码:" + result);

    }
}
