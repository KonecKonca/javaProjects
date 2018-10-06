package com.kozitski.triangle.util;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;


public class TriangleUtilTest {
    private ArrayList<PointForTriangle> points;

    @BeforeClass
    public void init(){
        points = new ArrayList<>(Arrays.asList(PointForTriangle.getInstance(0, 1),
                PointForTriangle.getInstance(-5, 45), PointForTriangle.getInstance(20, 90)));
    }

    @Test
    public void isCanBeTriangleTestTrue(){
        assertTrue(TriangleUtil.isCanBeTriangle(
                PointForTriangle.getInstance(1, 2),
                PointForTriangle.getInstance(2, 3),
                PointForTriangle.getInstance(3, 5)
        ));
    }
    @Test
    public void isCanBeTriangleTestFalse(){
        assertFalse(TriangleUtil.isCanBeTriangle(
                PointForTriangle.getInstance(10, 2),
                PointForTriangle.getInstance(10, 3),
                PointForTriangle.getInstance(10, 5)
        ));
    }
    @Test
    public void calculateSides(){
        TriangleUtil.calculateSides(points.get(0), points.get(1), points.get(2));
    }
    @Test
    public void calculateAngles(){
        List<Double> sides = TriangleUtil.calculateSides(points.get(0), points.get(1), points.get(2));
        TriangleUtil.calculateAngles(sides.get(0), sides.get(1), sides.get(2));
    }
}
