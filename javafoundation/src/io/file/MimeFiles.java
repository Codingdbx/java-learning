package io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * created by dbx on 2019/2/28
 */
public class MimeFiles {

    public static void main(String[] args) throws IOException {

        Path filename= Paths.get("E:\\Desktop\\运维密码.txt");

        //确定MIME类型
        try {
            String type = Files.probeContentType(filename);
            if (type == null)
                System.err.format("'%s' has an" + " unknown filetype.%n", filename);
            else if(type.equals("text/plain"))
                System.out.format("'%s' is" + " a plain text file.%n", filename);

        } catch (IOException x) {
            System.err.println(x);
        }

        //默认文件系统
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
        System.out.format("matcher:"+matcher.toString()+".%n");

        //路径字符串分隔符
        String separator0 = File.separator;
        System.out.format("separator0:"+separator0.toString()+".%n");

        String separator1 = FileSystems.getDefault().getSeparator();
        System.out.format("separator1:"+separator1.toString()+".%n");

        //文件系统的文件存储
        for (FileStore store: FileSystems.getDefault().getFileStores()) {
            System.out.format("store:"+store.name()+".%n");
        }

        Path file = Paths.get("E:\\Desktop\\运维密码.txt");
        FileStore store= Files.getFileStore(file);
        System.out.format("store2:"+store.name()+".%n");
    }
}
