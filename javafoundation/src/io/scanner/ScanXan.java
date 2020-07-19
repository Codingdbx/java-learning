package io.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * created by dbx on 2019/2/18
 */
public class ScanXan {

    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("D:\\ideaprojects\\notes.test\\src\\banner.txt")));

            //指定正则表达式,按逗号分割
            //s.useDelimiter(",\\s*");
            s.useDelimiter(",\\\\s*");
            //一般情况下扫描程序使用空格分隔。（空格字符包括空格，制表符和行终止符)
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
