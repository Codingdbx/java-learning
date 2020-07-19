package keyword.key_transient;

import java.io.Serializable;

/**
 * <p>Description:  测试关键字 transient</p>
 *
 * @author dbix
 * @date 2019/10/25
 * @since JDK1.8
 */
public class User2 implements Serializable  {

    private transient String name;
    private transient int age;
    private static String sex;
    private String country;

    private final transient String favorite = "play games";

    public User2(String name, int age,String sex, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex="+ sex + '\'' +
                ", country='" + country + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
