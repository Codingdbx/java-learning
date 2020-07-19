package keyword.key_final;

/**
 * final 关键字
 * created by dbx on 2019/2/16
 */
public final class Parent {

    private String name="dbx";

    public String getName(){

        return name;
    }

    public static void main(String[] args) {
        Parent p=new Parent();
        System.out.println(p.getName());
    }
}

//被final修饰的类不能被继承
/*
class son extends Parent{

}*/
