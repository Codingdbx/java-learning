package io.streams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * created by dbx on 2019/2/22
 */
public class CopyBytesToCharacters {

    public static void main(String[] args) throws Exception {

        InputStream in=System.in;//读取键盘输入的字节流，如果是读取一个中文，需要读两次才可以

        InputStreamReader ir = new InputStreamReader(in);//将字节流转换为字符流。如果是读一个中文，一次就可以读完

        BufferedReader br = new BufferedReader(ir);//字节流转换成字符流就可以使用BufferedReader装饰流。也就可以使用readLine方法

        String temp = null;

        while((temp=br.readLine())!=null){
            if(temp.equals("exit")){
                break;
            }
            System.out.println(temp);
        }
    }
}
