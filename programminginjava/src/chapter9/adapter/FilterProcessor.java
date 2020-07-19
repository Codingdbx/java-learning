package chapter9.adapter;

import chapter9.interfaces.Apply;
import chapter9.waveform.BandPass;
import chapter9.waveform.HighPass;
import chapter9.waveform.LowPass;
import chapter9.waveform.Waveform;

/**
 * created by dbx on 2018/10/23
 */
public class FilterProcessor {
    public static void main(String[] args) {

        Waveform w=new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),w);

    }
}
