package com.mowitnow.mowing.infra;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {


    public List<String> readLines(String mowersInputFileName) {

        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(mowersInputFileName).toURI());
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("error while reading file content: " + e);
        } catch (URISyntaxException e) {
            throw new RuntimeException("error while reading file path: " + e);
        }
    }
}
