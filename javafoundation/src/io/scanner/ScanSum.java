package io.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * created by dbx on 2019/2/18
 */
public class ScanSum {

    public static void main(String[] args) throws IOException {

        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("D:\\ideaprojects\\notes.test\\src\\usnumbers.txt")));
            //在CHINA语言环境中
            s.useLocale(Locale.CHINA);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                    System.out.println( s.next());
                }
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }
}
