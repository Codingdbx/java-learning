package annotation.predefinedannotationtypes;

/**
 * 注解
 * created by dbx on 2019/3/4
 */

public class DeprecatedAnnotation extends SuperClass{

    /*预定义注解*/

    // 1.@Deprecated 注解表示已弃用标记的元素
    @Deprecated
    static void deprecatedMethod() { }

    // 2.@Override将方法标记为超类方法
    // 已被覆盖
    @Override
    int overriddenMethod(){

        return 1;
    }

    // 3.use a deprecated method and tell
    // compiler not to generate a warning
    //在以下示例中，使用了不推荐使用的方法，编译器通常会生成警告。但是，在这种情况下，注解会导致警告被抑制。
    //Java语言规范列出了两个类别：deprecation和unchecked。
    @SuppressWarnings("deprecation")
    void useDeprecatedMethod() {
        // deprecation warning
        this.deprecatedMethod();
    }

//  4.@SafeVarargs注解在应用于方法或构造函数时，断言代码不对其varargs参数执行可能不安全的操作。
//    使用此注解类型时，varargs将禁止与使用相关的未经检查的警告。


//  5.@FunctionalInterface   Java-SE 8中引入的@FunctionalInterface注解表明类型声明旨在成为Java语言规范定义的功能接口。


    /*元注解*/  //适用于其他注解的注解称为元注解。



//    1.@Retention @Retention annotation指定标记注解的存储方式：
//
//    RetentionPolicy.SOURCE - 标记的注解仅保留在源级别中，并由编译器忽略。
//    RetentionPolicy.CLASS - 标记的注解在编译时由编译器保留，但Java虚拟机（JVM）会忽略。
//    RetentionPolicy.RUNTIME - 标记的注解由JVM保留，因此运行时环境可以使用它。

//    2.@Documented @Documented注解表明，无论何时使用指定的注解，都应使用Javadoc工具记录这些元素。（默认情况下，注解不包含在Javadoc中。）有关更多信息，请参阅 Javadoc工具页面。
//
//    3.@Target @Target注解标记另一个注解，以限制可以应用注解的Java元素类型。目标注解指定以下元素类型之一作为其值：
//
//    ElementType.ANNOTATION_TYPE 可以应用于注解类型。
//    ElementType.CONSTRUCTOR 可以应用于构造函数。
//    ElementType.FIELD 可以应用于字段或属性。
//    ElementType.LOCAL_VARIABLE 可以应用于局部变量。
//    ElementType.METHOD 可以应用于方法级注解。
//    ElementType.PACKAGE 可以应用于包声明。
//    ElementType.PARAMETER 可以应用于方法的参数。
//    ElementType.TYPE 可以应用于类的任何元素。

//    4.@Inherited @Inherited注解表明注解类型可以从超类继承。（默认情况下不是这样。）当用户查询注解类型并且该类没有此类型的注解时，将查询类的超类以获取注解类型。此注解仅适用于类声明。
//
//    5.@Repeatable   Java-SE 8中引入的@Repeatable注解表明标记的注解可以多次应用于相同的声明或类型使用。有关更多信息，请参阅 重复注解。


}
