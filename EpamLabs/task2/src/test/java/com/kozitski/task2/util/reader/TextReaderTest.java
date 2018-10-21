package com.kozitski.task2.util.reader;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextReaderTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void testReadAllTextFalse() {
        TextReader.readAllText(TextReader.INPUT_DATA_PATH + "343r");
    }

    @Test()
    public void testReadAllTextTrue() {
        TextReader.readAllText(TextReader.INPUT_DATA_PATH);
    }

}