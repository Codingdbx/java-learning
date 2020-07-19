package io.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * created by dbx on 2019/2/20
 */
public class JoiningTwoPaths {

    public static void main(String[] args) {
        // Microsoft Windows
        Path p0 = Paths.get("C:\\home\\joe\\foo");
        // Result is C:\home\joe\foo\bar,追加路径
        System.out.format("%s%n", p0.resolve("bar"));

        for (Path name: p0) {
            System.out.println(name);
        }

        System.out.println("-----------------------");

        // Result is /home/joe,追加路径,重复的话会被替换掉
        System.out.println(Paths.get("C:\\home\\joe\\foo").resolve("/home/joe"));

        Path p1 = Paths.get("joe");
        Path p2 = Paths.get("sally");

        //在两条路径之间创建路径
        // Result is ../sally
        Path p1_to_p2 = p1.relativize(p2);
        System.out.println(p1_to_p2);
        // Result is ../joe
        Path p2_to_p1 = p2.relativize(p1);
        System.out.println(p2_to_p1);

        //从一个路径到另一个路径
        Path p3 = Paths.get("home");
        Path p4 = Paths.get("home/sally/bar");
        // Result is sally/bar
        Path p3_to_p4 = p3.relativize(p4);
        System.out.println(p3_to_p4);
        // Result is ../..
        Path p4_to_p3 = p4.relativize(p3);
        System.out.println(p4_to_p3);


        Path path = Paths.get("...");
        Path otherPath = Paths.get("...");
        Path beginning = Paths.get("/home");
        Path ending = Paths.get("foo");

        if (path.equals(otherPath)) {
            // equality logic here
        } else if (path.startsWith(beginning)) {
            // path begins with "/home"
        } else if (path.endsWith(ending)) {
            // path ends with "foo"
        }
    }
}
