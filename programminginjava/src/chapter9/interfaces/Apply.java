package chapter9.interfaces;



/**
 * created by dbx on 2018/10/23
 */
public class Apply {

    public static void process(Processor p, Object s){
        System.out.println("Using Processor "+p.name());
        System.out.println(p.process(s));
    }
}
