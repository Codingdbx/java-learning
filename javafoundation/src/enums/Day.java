package enums;

/**
 * 枚举类型
 *
 * created by dbx on 2019/3/4
 */
public enum Day {

    // 枚举类主体可以包括方法和其他字段
    // 所有枚举都隐式扩展java.lang.Enum。因为类只能扩展一个父类（请参阅 声明类），
    // 所以Java语言不支持多重继承状态（请参阅 状态，实现和类型的多重继承），因此枚举不能扩展任何其他内容。
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}
