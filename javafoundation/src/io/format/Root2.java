package io.format;

/**
 * created by dbx on 2019/2/18
 */
public class Root2 {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.format("The square root of %d is %f.%n", i, r);

//        d 将整数值格式化为十进制值。
//        f 将浮点值格式化为十进制值。
//        n 输出特定于平台的线路终结器(正确行分隔符%n)。

//        x 将整数格式化为十六进制值。
//        s 将任何值格式化为字符串。
//        tB 将整数格式化为特定于语言环境的月份名称。

//        注意：除了%%和之外%n，所有格式说明符必须与参数匹配。如果他们不这样做，则会抛出异常。

    }
}

