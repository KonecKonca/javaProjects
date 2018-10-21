package com.kozitski.task2.util.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);
    public static final String INPUT_DATA_PATH = "src/main/resources/data/input.txt";

    public static String readAllText(String path){
        StringBuilder allText = new StringBuilder();

        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            for(String str : list){
                allText.append(str);
            }

            LOGGER.info("File was correctly read");

        } catch (IOException e) {
            LOGGER.fatal("file exists");
            throw new RuntimeException("File exists on the next path: " + path);
        }

        return allText.toString();
    }

}
