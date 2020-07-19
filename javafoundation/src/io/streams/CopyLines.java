package io.streams;

import java.io.*;

/**
 * 缓冲字符流-Character Streams
 *
 * created by dbx on 2019/2/18
 */
public class CopyLines {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("D:\\ideaprojects\\notes.test\\src\\xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("D:\\ideaprojects\\notes.test\\src\\characteroutput.txt"));

            String l;
            //BufferedReader与 BufferedWriter创建缓冲字符流,一行一行的读取。
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
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
