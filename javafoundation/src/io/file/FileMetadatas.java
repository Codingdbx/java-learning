package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

/**
 * 管理元数据（文件和文件存储属性）
 *
 * created by dbx on 2019/2/28
 */
public class FileMetadatas {

    public static void main(String[] args) throws IOException{

        //基本文件属性
        Path file = Paths.get("");

        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());


        //设置时间戳
        Path file2 = Paths.get("");
        BasicFileAttributes attr2 = Files.readAttributes(file2, BasicFileAttributes.class);
        long currentTime = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(file2, ft);

        //设置文件所有者或组所有者

        Path file3 = Paths.get("");
        UserPrincipal owner = file3.getFileSystem().getUserPrincipalLookupService()
                .lookupPrincipalByName("sally");
        Files.setOwner(file3, owner);

        Path file4 = Paths.get("");
        GroupPrincipal group = file4.getFileSystem().getUserPrincipalLookupService()
                        .lookupPrincipalByGroupName("green");
        Files.getFileAttributeView(file4, PosixFileAttributeView.class)
                .setGroup(group);

    }
}
