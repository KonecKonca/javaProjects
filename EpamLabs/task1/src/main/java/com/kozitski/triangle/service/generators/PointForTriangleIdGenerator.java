package com.kozitski.triangle.service.generators;

public class PointForTriangleIdGenerator {
    private static long counter = 1;

    public static long getId(){
        return counter++;
    }
}
