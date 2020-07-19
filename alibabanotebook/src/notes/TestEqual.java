package notes;


/**
 * created by dbx on 2018/11/2
 */
public class TestEqual {

    private static String a = "";
    private static String b = null;
    private static String c = "";

    public static void main(String[] args) {
        System.out.println(a==c);

        b=c;
        System.out.println(a==b);
    }
}
