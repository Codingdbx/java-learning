package chapter9.interfaces;

/**
 * 基类
 * created by dbx on 2018/10/23
 */
public interface Processor {

    public String name();

    Object process(Object input);
}
