package io.streams.printstream;

import java.io.*;

/**
 * <p>Description: PrintStream 与 PrintWriter</p>
 *
 * @author dbx
 * @date 2020/4/26 10:03
 * @since JDK1.8
 */
public class TestPrint {

    public static void main(String[] args) throws Exception{

//        print();
//        print2();
        printTest();

        if (true) {
            throw new Exception("this is always true");
        }


    }

    static void print() {
        // 通过System.out为PrintWriter实例化
        PrintWriter out = new PrintWriter(System.out);
        // 向屏幕上输出
        out.println("Hello World!");
        out.close();    //如果此句不写，则没有内容，跟PrintStream有区别
    }

    static void print2() {
        PrintStream ps = System.out;
        ps.println("Hello World2!");
    }

    /**
     * 收集日志信息
     *
     * @throws IOException
     */
    static void printTest() {
        File file = new File("C:\\Users\\Administrator\\Desktop\\a.txt");
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //默认标准的输出流就是输向控制台
        System.setOut(printStream);    //重新设置了标准的输出流对象
        System.out.println("重新设置了输出地");

        //收集异常的日志信息：
        File logFile = new File("C:\\Users\\Administrator\\Desktop\\log.log");
        //追加信息：
        PrintStream logPrintStream = null;
        try {
            logPrintStream = new PrintStream(new FileOutputStream(logFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int a = 12 / 0;
            System.out.println("a=" + a);
        } catch (Exception e) {
            e.printStackTrace(logPrintStream);
        }

        //关闭资源
        printStream.close();
    }


}
