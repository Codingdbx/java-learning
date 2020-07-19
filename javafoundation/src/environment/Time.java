package environment;

/**
 * created by dbx on 2019/4/8
 */
public class Time {

    public static void main(String[] args) {

        long millis = System.currentTimeMillis();//精确到毫秒
        System.out.println("当前毫秒："+millis);


        long nanoTime = System.nanoTime();//精确到纳秒
        System.out.println("当前纳秒："+nanoTime);


    }
}
