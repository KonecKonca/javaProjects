package com.kozitski.triangle.util;

import com.kozitski.triangle.entity.PointForTriangle;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleUtilsTest {
    @Test
    public void isCanBeTriangleTestTrue(){
        assertTrue(TriangleUtils.isCanBeTriangle(
                PointForTriangle.getInstance(1, 2),
                PointForTriangle.getInstance(2, 3),
                PointForTriangle.getInstance(3, 5)
        ));
    }
    @Test
    public void isCanBeTriangleTestFalse(){
        assertFalse(TriangleUtils.isCanBeTriangle(
                PointForTriangle.getInstance(10, 2),
                PointForTriangle.getInstance(10, 3),
                PointForTriangle.getInstance(10, 5)
        ));
    }
}
