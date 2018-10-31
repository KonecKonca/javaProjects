package com.kozitski.triangle.service;


import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class TriangleOperationsTest {
    private Triangle triangle;

    @BeforeClass
    public void initial(){
        triangle = Triangle.getInstance(PointForTriangle.getInstance(0, 0)
            , PointForTriangle.getInstance(0, 7), PointForTriangle.getInstance(7, 0));
    }

    @Test
    public void perimeterTest(){
        assertEquals(24, TriangleOperations.perimeter(triangle),0.3);
    }
    @Test
    public void squareTest(){
        assertEquals(24.5, TriangleOperations.square(triangle),0.3);
    }
    @Test
    public void isRectangularTrue(){
        assertTrue(TriangleOperations.isRectangular(triangle));
    }
    @Test
    public void isRectangularFalse(){
        assertFalse(TriangleOperations.isRectangular(Triangle.getInstance(PointForTriangle.getInstance(0, 0),
                PointForTriangle.getInstance(-2, 3), PointForTriangle.getInstance(100, 0))));
    }
    @Test
    public void isEquilateralTrue(){
        assertTrue(TriangleOperations.isEquilateral(Triangle.getInstance(PointForTriangle.getInstance(5, 7),
                PointForTriangle.getInstance(2, 2), PointForTriangle.getInstance(8, 2))));
    }
    @Test
    public void isEquilateralFalse(){
        assertFalse(TriangleOperations.isEquilateral(triangle));
    }
    @Test
    public void isIsoscelesTrue(){
        assertTrue(TriangleOperations.isIsosceles(triangle));
    }
    @Test
    public void isIsoscelesFalse(){
        assertFalse(TriangleOperations.isIsosceles(Triangle.getInstance(PointForTriangle.getInstance(5, 7),
                PointForTriangle.getInstance(2, 2), PointForTriangle.getInstance(8, 22))));
    }
    @Test
    public void isObtuseTrue(){
        assertTrue(TriangleOperations.isObtuse(Triangle.getInstance(PointForTriangle.getInstance(5, 7),
                PointForTriangle.getInstance(2, 2), PointForTriangle.getInstance(8, 22))));
    }
    @Test
    public void isObtuseFalse(){
        assertFalse(TriangleOperations.isObtuse(triangle));
    }
}
