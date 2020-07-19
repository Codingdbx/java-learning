package chapter9.interfaces;

/**
 * created by dbx on 2018/10/23
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    public abstract Object process(Object input);

    public static String s = "hello word";

    public static void main(String[] args) {
        Apply.process(new Upcase(),s);
        Apply.process(new Downcase(),s);
        Apply.process(new Splitter(),s);
    }
}
