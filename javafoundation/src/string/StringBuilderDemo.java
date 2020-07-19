package string;

/**
 * created by dbx on 2019/3/10
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        sb.reverse();  // reverse it 字符串反转

        System.out.println(sb);
    }
}
