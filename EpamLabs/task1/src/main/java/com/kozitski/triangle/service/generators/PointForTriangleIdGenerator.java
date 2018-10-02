package com.kozitski.triangle.service.generators;

import com.kozitski.triangle.service.TriangleOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointForTriangleIdGenerator {
    private static long counter = 1;

    private static final Logger LOGGER = LogManager.getLogger(PointForTriangleIdGenerator.class);

    public static long getId(){
        LOGGER.debug("Was generate PointForTriangleIdGenerator with id: " + counter);
        return counter++;
    }
}
