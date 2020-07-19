package chapter9.waveform;

/**
 * 基类
 * created by dbx on 2018/10/23
 */
public class Filter {

    public String name(){
        return this.getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return  input;
    }
}
