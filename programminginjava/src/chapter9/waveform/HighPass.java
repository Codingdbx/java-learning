package chapter9.waveform;

/**
 * created by dbx on 2018/10/23
 */
public class HighPass extends Filter {

    double cutoff;

    public HighPass(double cutoff){
        this.cutoff=cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
