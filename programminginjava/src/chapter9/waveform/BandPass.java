package chapter9.waveform;

/**
 * created by dbx on 2018/10/23
 */
public class BandPass extends Filter {

    double lowCutoff,highCutoff;

    public BandPass(double lowCut,double highCut){
        this.lowCutoff=lowCut;
        this.highCutoff=highCut;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
