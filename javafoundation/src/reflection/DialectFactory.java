package reflection;

import reflection.util.ClassUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/6/17 16:38
 * @since JDK1.8
 */
public class DialectFactory {

    private static final Map<String, Class<?>> DIALECT_MAP = new HashMap<>();

    public void registerDialect(String packageName) {

        Set<Class<?>> classes = ClassUtil.scanPackage(packageName);

        for (Class<?> clazz : classes) {

            if (AbstractDialect.class.isAssignableFrom(clazz)) {
                try {
                    AbstractDialect dialect = (AbstractDialect)clazz.newInstance();

                    DIALECT_MAP.put(dialect.getAliasName(), clazz);

                } catch (Exception e) {
                    e.printStackTrace();
                    // log.warn("实例化对象失败");
                }
            }
        }
    }

    public Class<?> getDialectClass(String aliasName){
        return DIALECT_MAP.get(aliasName);
    }

    public static void main(String[] args) throws Exception {
        DialectFactory factory = new DialectFactory();

        //注册所有类型
        factory.registerDialect("reflection.dialect");

        Class<?> mysql = factory.getDialectClass("mysql");

        AbstractDialect dialect = (AbstractDialect)mysql.newInstance();

        String aliasName = dialect.getAliasName();

        dialect.deal();

        System.out.println("aliasName---" + aliasName);

    }
}
