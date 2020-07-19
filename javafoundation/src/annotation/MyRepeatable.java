package annotation;

import java.lang.annotation.*;

/**
 * Created by DBC-PC on 2018/9/19
 */

//使用@Repeatable将@MyRepeatable变成可重复的
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatables.class)
public @interface MyRepeatable {
    String role();
}
