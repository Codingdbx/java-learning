package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NIO创建文件
 * created by dbx on 2019/2/28
 */
public class CreateFiles {

    public static void main(String[] args) {

        Path file = Paths.get("e:\\nihao.txt");
        try {
            // Create the empty file with default permissions, etc.
            Files.createFile(file);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }

        if (Files.exists(file)) {

            System.out.format("该文件已验证存在");

        }else if(Files.notExists(file)){//!Files.exists(path)不等于Files.notExists(path)
            System.out.format("该文件已验证不存在");

        }else {
            System.out.format("文件的状态未知。当程序无权访问该文件时，可能会发生此结果");
        }

    }
}
