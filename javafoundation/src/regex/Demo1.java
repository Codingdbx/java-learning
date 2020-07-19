package regex;

/**
 * <p>Description: 正则表达式‘+’和‘*’的区别</p>
 *
 * @author dbx
 * @date 2020/3/27 16:10
 * @since JDK1.8
 */
public class Demo1 {

    public static void main(String[] args) {
        String sql0 = "select * from user \nOrder  \t\f\n\r  by\f id\t";
        String sql1 = "select * from (select * from user Order by id) order by";


        //处理sql中的 order by 字段
        //“*”元字符规定其前导字符必须在目标对象中出现零次或连续多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
        //“+”元字符规定其前导字符必须在目标对象中连续出现一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，"zzzooo",但不能匹配 "z"。+ 等价于 {1,}。
        String str = sql0.toLowerCase().replaceAll("\\s+", "");
        String str1 = sql0.toLowerCase().replaceAll("\\s*", "");
        String str2 = sql0.toLowerCase().replaceAll("\\s*", " ");
        String str3= sql0.toLowerCase().replaceAll("\\s+", " ");
        if (sql0.toLowerCase().contains("order by")) {

            String order_by = sql0.substring(0, sql0.toLowerCase().lastIndexOf("order by"));

        }
    }
}
