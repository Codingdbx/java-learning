package reflection.dialect;

import reflection.AbstractDialect;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/6/17 16:33
 * @since JDK1.8
 */
public class SqlServerDialect extends AbstractDialect {
    @Override
    public void deal() {
        System.out.println("i am sqlserver dialect");
    }

    @Override
    public String getAliasName() {
        return "sqlserver";
    }
}