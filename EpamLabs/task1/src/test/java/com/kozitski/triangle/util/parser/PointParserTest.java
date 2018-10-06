package com.kozitski.triangle.util.parser;

import com.kozitski.triangle.util.constants.PathsForConfigFiles;
import org.testng.annotations.Test;

import static com.kozitski.triangle.service.PointParserTest.DATA_PATH;
import static org.testng.Assert.*;

public class PointParserTest {

    @Test
    public void testGetAllPoints() {
        PointParser.getAllPoints(PathsForConfigFiles.VALIDATION_CONFIGURATIONS.getPath());
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testGetTriangleFalse() {
        PointParser.getTriangle();
    }
    @Test
    public void testGetTriangleTrue() {
        PointParser.getAllPoints(DATA_PATH + "incorrectDAta.txt");
        PointParser.getTriangle();
    }

}