package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 检查文件或目录
 *
 * created by dbx on 2019/2/28
 */
public class CheckFiles {

//  该文件已验证存在。exists
//  该文件已验证不存在。notExists  //!Files.exists(path)不等于Files.notExists(path)
//
//  文件的状态未知。当程序无权访问该文件时，可能会发生此结果。

    public static void main(String[] args) throws IOException{

        Path file = Paths.get("E:\\Desktop\\运维密码.txt");

        //isReadable(Path), isWritable(Path) 和 isExecutable(Path)
        boolean isRegularExecutableFile = Files.isRegularFile(file) & Files.isReadable(file) & Files.isExecutable(file);

        System.out.format("result is %s.%n", isRegularExecutableFile);

        Path p1 = Paths.get("foo");
        Path p2 = Paths.get("foo2");

        if (Files.isSameFile(p1, p2)) {
            // Logic when the paths locate the same file
            System.out.format("true.");
        }


    }

}
