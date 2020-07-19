package keyword.key_final;

/**
 * created by dbx on 2019/2/16
 */
public class Parent3 {

    private final int age=22;//初始化赋值
    private final String name = "abd";//初始化赋值

    private final String gender;

    public Parent3(String gender){
        //在构造方法里赋值
        this.gender=gender;

        //基本类型变量的值不能改变。引用类型的地址的值不能修改，对象里面的内容还是可以改变的
        //this.age=25;
        //this.name="123";

    }

}
