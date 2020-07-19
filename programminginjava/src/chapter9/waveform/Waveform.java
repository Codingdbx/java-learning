package chapter9.waveform;

/**
 * created by dbx on 2018/10/23
 */
public class Waveform {

    private static long counter;
    private final long id=counter++;

    public String toString(){
        return "Waveform "+id;
    }
}
