package com.kozitski.triangle.service;

import com.kozitski.triangle.entity.AllEnteredPoints;
import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.exception.LessThanNecessaryPoints;
import com.kozitski.triangle.util.parser.InputDataParser;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InputDataParserTest {

    private AllEnteredPoints allEnteredPoints;

    @Test
    public void getAllPointsTrue(){
        allEnteredPoints = InputDataParser.getAllPoints("data/correctDAta.txt");
        int invalidNumber = allEnteredPoints.invalidStringsSize();
        assertEquals(0, invalidNumber);
    }
    @Test
    public void getAllPointsFalse(){
        allEnteredPoints = InputDataParser.getAllPoints("data/incorrectDAta.txt");
        int invalidNumber = allEnteredPoints.invalidStringsSize();
        assertNotEquals(0, invalidNumber);
    }

    @Test()
    public void getTriangleTrue(){
        InputDataParser.getAllPoints("data/incorrectData.txt");
        InputDataParser.getTriangle();
    }

    @Test(expectedExceptions = LessThanNecessaryPoints.class)
    public void getTriangleFalse(){
        InputDataParser.getAllPoints("data/lessPoints.txt");
        InputDataParser.getTriangle();
    }


}
