package com.kozitski.task3.util.validation;

import com.kozitski.task3.util.constants.PropertyPath;
import com.kozitski.task3.util.generator.ProductIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WagonIdGenerator {
    private static final Logger LOGGER = LogManager.getLogger(WagonIdGenerator.class);
    private static final Properties PROPERTIES;
    static {
        PROPERTIES = new Properties();

        try(FileInputStream inputStream = new FileInputStream(PropertyPath.PRODUCT_VALIDATION_PATH)){
            PROPERTIES.load(inputStream);
        }
        catch (IOException e){
            LOGGER.fatal("Property file for indication allowed ID is not exist", e);
        }

        MAX_ID_BOUNDER = Integer.parseInt(PROPERTIES.getProperty("maxWagonID"));
    }

    private static final long MAX_ID_BOUNDER;
    private static long counter;

    private WagonIdGenerator() { }

    public static long generateId(){
        if(counter < MAX_ID_BOUNDER){
            return counter++;
        }
        else {
            LOGGER.fatal("ID for Wagon is not generated");
            throw new RuntimeException("Id value is bigger than, allowed: " + counter);
        }
    }
}
