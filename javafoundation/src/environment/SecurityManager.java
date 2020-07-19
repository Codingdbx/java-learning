package environment;

/**
 * created by dbx on 2019/4/8
 */
public class SecurityManager {

    public static void main(String[] args) {

        //如果没有安全管理器，则此方法返回null
        java.lang.SecurityManager securityManager = System.getSecurityManager();

    }
}
