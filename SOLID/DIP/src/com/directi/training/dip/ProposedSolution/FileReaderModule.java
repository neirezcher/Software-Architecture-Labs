package com.directi.training.dip.ProposedSolution;
import java.io.*;

public class FileReaderModule implements IReader {
    private final String filePath;

    public FileReaderModule(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}