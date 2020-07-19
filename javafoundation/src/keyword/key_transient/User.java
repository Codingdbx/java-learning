package keyword.key_transient;

import java.io.Serializable;

/**
 * <p>Description:  </p>
 *
 * @author dbix
 * @date 2019/10/25
 * @since JDK1.8
 */
public class User implements Serializable {

    private String name;
    private int age;
    private String sex;
    private String country;

    private String favorite;

    public User(String name, int age, String sex, String favorite, String country) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.favorite = favorite;
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
