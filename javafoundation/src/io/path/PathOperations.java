package io.path;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 路径操作
 * created by dbx on 2019/2/19
 */
public class PathOperations {

    public static void main(String[] args) {

        //创建路径
        Path p1 = Paths.get("/tmp/foo");
        //Path p2 = Paths.get(args[0]);
        Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));

        Path p4 = FileSystems.getDefault().getPath("/users/sally");

        Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");


    }
}
