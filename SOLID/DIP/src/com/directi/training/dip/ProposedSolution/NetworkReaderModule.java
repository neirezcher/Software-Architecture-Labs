package com.directi.training.dip.ProposedSolution;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;

public class NetworkReaderModule implements IReader {
    private final URL url;

    public NetworkReaderModule(URL url) {
        this.url = url;
    }

    @Override
    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        try (InputStream in = url.openStream();
             InputStreamReader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        }
        return content.toString();
    }
}
