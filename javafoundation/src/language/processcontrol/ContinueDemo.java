package language.processcontrol;

/**
 * 跳过循环
 * created by dbx on 2019/3/2
 */
public class ContinueDemo {

    public static void main(String[] args) {

        String searchMe = "peter piper picked a " + "peck of pickled peppers";
        int max = searchMe.length();
        int numPs = 0;

        for (int i = 0; i < max; i++) {
            // interested only in p's
            if (searchMe.charAt(i) != 'p')
                continue;//直接跳过循环的其余部分，并继续执行下一个字符。

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }
}
