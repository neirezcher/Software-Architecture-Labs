package com.directi.training.dip.ProposedSolution;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterModule implements IWriter {
    private final String filePath;

    public FileWriterModule(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int write(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            return data.length();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
