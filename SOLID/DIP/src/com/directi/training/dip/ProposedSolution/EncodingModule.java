package com.directi.training.dip.ProposedSolution;

import java.io.IOException;
import java.util.Base64;

public class EncodingModule {
    private final IReader reader;
    private final IWriter dataStore;

    public EncodingModule(IReader reader, IWriter dataStore) {
        this.reader = reader;
        this.dataStore = dataStore;
    }

    public void encodeAndStore() throws IOException {
        String input = reader.read();
        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());
        dataStore.write(encodedString);
    }
}
