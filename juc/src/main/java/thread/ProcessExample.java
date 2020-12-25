package thread;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 进程
 *
 * created by dbx on 2019/3/21
 */
public class ProcessExample {

    public static void main(String[] args) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("myCommand", "myArg1", "myArg2");
        Map<String, String> env = pb.environment();
        env.put("VAR1", "myValue");
        env.remove("OTHERVAR");

        env.put("VAR2", env.get("VAR1") + "suffix");
        pb.directory(new File("F:\\Process"));
        File log = new File("F:\\Process\\log");

        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));

        Process p = pb.start();

        assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
        assert pb.redirectOutput().file() == log;
        assert p.getInputStream().read() == -1;
    }
}
