package chapter9.interfaces;


import java.util.Arrays;

/**
 * created by dbx on 2018/10/23
 */
public class Splitter extends StringProcessor {

    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
