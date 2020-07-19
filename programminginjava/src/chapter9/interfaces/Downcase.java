package chapter9.interfaces;


/**
 * created by dbx on 2018/10/23
 */
public class Downcase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
