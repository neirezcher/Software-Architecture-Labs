package com.directi.training.dip.ProposedSolution;
import java.util.HashMap;
import java.util.Map;

public class MyDatabase implements IWriter {
    private static final Map<Integer, String> _data = new HashMap<>();
    private static int _count = 0;

    @Override
    public int write(String data) {
        _data.put(++_count, data);
        return _count;
    }
}
