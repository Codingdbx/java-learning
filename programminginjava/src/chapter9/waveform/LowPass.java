package chapter9.waveform;

/**
 * created by dbx on 2018/10/23
 */
public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff){
        this.cutoff=cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
