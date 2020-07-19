package io.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流-Character Streams
 *
 * created by dbx on 2019/2/18
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("D:\\ideaprojects\\notes.test\\src\\baidu.txt");
            outputStream = new FileWriter("D:\\ideaprojects\\notes.test\\src\\out2.txt");

            int c;
            //一个字符一个字符的读取,一个汉字三个字节
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
