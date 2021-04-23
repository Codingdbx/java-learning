package functional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @since 2021/4/23 17:23
 */
public class TestMain02 {

    public static String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();    //←─这就是做有用工作的那行代码
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }


    public static String processFile(BufferedReaderProcessor p) throws
            IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);    //←─处理BufferedReader对象
        }
    }


    public static void main(String[] args) throws Exception{
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
