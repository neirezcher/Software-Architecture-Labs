package com.directi.training.dip.ProposedSolution;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EncodingModuleClient {
    public static void main(String[] args) throws IOException {
        // Lire depuis un fichier
        IReader fileReader = new FileReaderModule("DIP/src/com/directi/training/dip/exercise/beforeEncryption.txt");
        IWriter fileWriter = new FileWriterModule("DIP/src/com/directi/training/dip/exercise/afterEncryption.txt");
        EncodingModule fileEncoding = new EncodingModule(fileReader, fileWriter);
        fileEncoding.encodeAndStore();

        // Lire depuis un réseau
        IReader networkReader = new NetworkReaderModule(new URL("http://example.com"));
        IWriter database = new MyDatabase();
        EncodingModule networkEncoding = new EncodingModule(networkReader, database);
        networkEncoding.encodeAndStore();
    }
}
