package com.kozitski.triangle.service.generators;

public class TriangleIdGenerator {
    private static long counter = 1;

    public static long getId(){
        return counter++;
    }
}
