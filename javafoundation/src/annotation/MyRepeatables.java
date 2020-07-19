package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by DBC-PC on 2018/9/19
 */

//容器注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatables {
    MyRepeatable [] value();//按照规定，它里面必须要有一个 value 的属性，属性类型是一个被 @Repeatable 注解过的注解，注意value它是数组;
}
