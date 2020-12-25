package RefTypeAndThreadLocal;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/11/6 22:25
 * @since JDK1.8
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("execute finalize method...");
    }
}
