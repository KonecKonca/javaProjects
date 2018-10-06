package com.kozitski.triangle.service;

import com.kozitski.triangle.entity.AllEnteredPoints;
import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.exception.PointException;
import com.kozitski.triangle.util.TriangleUtil;
import com.kozitski.triangle.util.parser.PointParser;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class PointParserTest {
    public static final String DATA_PATH = "src/main/resources/data/";
    private AllEnteredPoints allEnteredPoints;

    @Test(groups = "ALL_TESTS")
    public void getAllPointsTrue(){
        int actual = 0;
        allEnteredPoints = PointParser.getAllPoints(DATA_PATH + "correctDAta.txt");
        int expected = allEnteredPoints.invalidStringsSize();

        assertEquals(actual, expected);
    }
    @Test
    public void getAllPointsFalse(){
        int actual = 0;
        allEnteredPoints = PointParser.getAllPoints(DATA_PATH + "incorrectDAta.txt");
        int  expected = allEnteredPoints.invalidStringsSize();

        assertNotEquals(actual, expected);
    }

    @Test()
    public void getTriangleTrue(){
        PointParser.getAllPoints(DATA_PATH + "incorrectData.txt");
        PointParser.getTriangle();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void getTriangleFalse(){
        PointParser.getAllPoints(DATA_PATH + "lessPoints.txt");
        PointParser.getTriangle();
    }


}
