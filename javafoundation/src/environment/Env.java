package environment;

/**
 * 使用String参数，getenv返回指定变量的值
 *
 * created by dbx on 2019/4/8
 */
public class Env {
    public static void main (String[] args) {
        for (String env: args) {
            String value = System.getenv(env);
            if (value != null) {
                System.out.format("%s=%s%n", env, value);
            } else {
                System.out.format("%s is" + " not assigned.%n", env);
            }
        }
    }
}
