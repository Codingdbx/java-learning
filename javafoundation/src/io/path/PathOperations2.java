package io.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 检索有关路径的信息
 * created by dbx on 2019/2/19
 */
public class PathOperations2 {

    public static void main(String[] args) {

        // None of these methods requires that the file corresponding
        // to the Path exists 这些方法都不需要存在与Path对应的文件

        // Microsoft Windows syntax
        Path path = Paths.get("C:\\home\\joe\\foo");

        // Solaris syntax
        //Path path = Paths.get("/home/joe/foo");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());


    }
}
