package io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流-Byte Streams
 *
 * 一次写入一个字节的输出流
 * created by dbx on 2019/2/18
 */
public class CopyBytes {

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("D:\\ideaprojects\\notes.test\\src\\baidu.txt");
            out = new FileOutputStream("D:\\ideaprojects\\notes.test\\src\\out.txt");
            int c;

            //一次写入一个字节，一个英文字母是1个字节，一个汉字是一个字符2字节。
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
