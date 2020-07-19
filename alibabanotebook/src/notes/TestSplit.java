package notes;

public class TestSplit {
    /**
     * Split 字符串转数组越界问题
     * 当使用split方法 分割得到数组时，需要在最后一个分隔符后做有无内容的检查，否则会有越界的风险
     */
    public static void main(String[] args) {
        String str="a,b,c,,";
        String[] ary=str.split(",\\s*");
        System.out.println(ary.length);//结果是3

        //定义一个byte类型变量
        byte b = 1;
        //用一元加号后赋值给c，发现报错。
        //byte c = +b;
        //再赋值给整型变量d后能编译通过，证明b编程了int型。
        int d = +b;

        
    }
}
