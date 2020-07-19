package chapter6;

/**
 * 编译单元(一个java文件里)，
 * 只能有一个public 类
 *
 * Created by DBC-PC on 2018/7/22
 */
public class Test0 {

    public static void main(String[] args) {

        int i = 0;

        i++;

        System.out.println(i);
    }

    //内部类
    public class test1{

    }

}

//外部类
class test2{

}