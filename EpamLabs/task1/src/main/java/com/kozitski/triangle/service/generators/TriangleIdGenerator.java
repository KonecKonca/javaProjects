package com.kozitski.triangle.service.generators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleIdGenerator {
    private static long counter = 1;
    private static final Logger LOGGER = LogManager.getLogger(TriangleIdGenerator.class);

    public static long getId(){
        LOGGER.debug("Was generate TriangleIdGenerator with id: " + counter);
        return counter++;
    }
}
