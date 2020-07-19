package io.file;

import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * 复制文件或目录
 *
 * created by dbx on 2019/2/28
 */
public class CopyFiles {

    public static void main(String[] args) {

//        REPLACE_EXISTING - 即使目标文件已存在，也执行复制。如果目标是符号链接，则复制链接本身（而不是链接的目标）。
//                           如果目标是非空目录，则复制将失败并显示FileAlreadyExistsException异常。

//        COPY_ATTRIBUTES - 将与文件关联的文件属性复制到目标文件。支持的确切文件属性是文件系统和平台相关的，
//                          但last-modified-time跨平台支持并复制到目标文件。

//        NOFOLLOW_LINKS - 表示不应遵循符号链接。如果要复制的文件是符号链接，则复制链接（而不是链接的目标）。

        // Files.copy(source, target, REPLACE_EXISTING);
        // copy(InputStream, Path, CopyOptions...) 方法可用于将所有字节从输入流复制到文件
        // copy(Path, OutputStream) 方法可用于将所有字节从文件复制到输出流。
    }

}
