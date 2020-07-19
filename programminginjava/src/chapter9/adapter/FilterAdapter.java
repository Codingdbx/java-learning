package chapter9.adapter;

import chapter9.interfaces.Processor;
import chapter9.waveform.Filter;
import chapter9.waveform.Waveform;

/**
 * created by dbx on 2018/10/23
 */
public class FilterAdapter implements Processor {

    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
