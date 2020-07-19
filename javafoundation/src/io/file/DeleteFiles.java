package io.file;

import java.io.IOException;
import java.nio.file.*;

/**
 * 删除文件或目录
 *
 * created by dbx on 2019/2/28
 */
public class DeleteFiles {

    public static void main(String[] args) {

        Path path = Paths.get("foo");

        try {
            //可以删除文件，目录或链接。// deleteIfExists(Path)不会抛异常
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            // 此处捕获文件权限问题。
            System.err.println(x);
        }


    }
}
