package io.streams;

import java.io.*;

/**
 * 缓冲字节流-BufferedInputStream,BufferedOutputStream
 *
 * created by dbx on 2019/2/18
 */
public class CopyBufferBytes {

    public static void main(String[] args) throws IOException{

        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;

        try{
            bis=new BufferedInputStream(new FileInputStream("D:\\ideaprojects\\notes.test\\src\\xanadu2.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("D:\\ideaprojects\\notes.test\\src\\xanaduBuffer.txt"));

            //建立缓冲区大小,减少磁盘读写
            byte[] b = new byte[1024];
            int len;
            while ((len=bis.read(b))!=-1){
                bos.write(b,0,len);
            }

        }finally{

            if (bis!=null){
                bis.close();
            }
            if (bos!=null){
                bos.close();
            }
        }
    }

}
