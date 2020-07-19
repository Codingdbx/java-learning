package io.file;

import java.io.File;
import java.io.IOException;

/**
 * 旧IO创建文件
 * created by dbx on 2019/2/28
 */
public class CreateFilesByIO {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\stu\\bdqn.txt");

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();//父文件夹存不存在都会创建
            file.createNewFile();
            System.out.println("已创建文件的父目录！");
            System.out.println("已创建了文件!");
        } else if (file.getParentFile().exists() && !file.exists()) {
            System.out.println("父目录已存在！");
            file.createNewFile();
            System.out.println("已创建了文件!");
        } else {
            System.out.println("此文件已存在！");
        }

        if (file.delete()) {// 删除文件或空的文件夹
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        /*
         * if (!file.exists()) { file.createNewFile();// 可创建文件，不能创建文件夹
         * System.out.println("已创建文件");
         *
         * } else { System.out.println("此文件已存在！");
         *
         * System.out.println(file.getPath());// 获得文件的路径
         * System.out.println(file.getAbsoluteFile());// 获得文件的绝对路径
         * System.out.println(file.getName());// 获取文件的名称
         * System.out.println(file.getParent());// 获取文件的父目录路径名字符串
         * System.out.println(file.getParentFile());// 获取父目录的抽象路径名
         * System.out.println(file.length());// 文件的大小（字节数）
         *
         * }
         */

    }
}
