package com.kozitski.triangle.service;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import org.junit.Test;

public class ServiceTriangleTest {

    @Test
    public void test(){
        Triangle triangle  = Triangle.getInstance(PointForTriangle.getInstance(1, 1),
                PointForTriangle.getInstance(4, -1), PointForTriangle.getInstance(1, -2));
        System.out.println(triangle);

        System.out.println(TriangleOperations.perimeter(triangle));
        System.out.println(TriangleOperations.square(triangle));

        System.out.println(TriangleOperations.isEquilateral(triangle));
        System.out.println(TriangleOperations.isIsosceles(triangle));
        System.out.println(TriangleOperations.isObtuse(triangle));
        System.out.println(TriangleOperations.isRectangular(triangle));
    }

}
