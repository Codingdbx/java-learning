package annotation;

import java.lang.annotation.*;

/**
 * Created by DBC-PC on 2018/9/19
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

}
