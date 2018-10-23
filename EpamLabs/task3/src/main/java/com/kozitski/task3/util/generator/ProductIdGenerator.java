package com.kozitski.task3.util.generator;

import com.kozitski.task3.util.constants.PropertyPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class ProductIdGenerator {
    private static final Logger LOGGER = LogManager.getLogger(ProductIdGenerator.class);
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Properties PROPERTIES;
    static {
        PROPERTIES = new Properties();

        try(FileInputStream inputStream = new FileInputStream(PropertyPath.ALLOWED_ID_PATH)){
            PROPERTIES.load(inputStream);
        }
        catch (IOException e){
            LOGGER.error("Property file for indication allowed ID is not exist", e);
            MAX_ID_BOUNDER = 1500;
        }

        MAX_ID_BOUNDER = Long.parseLong(PROPERTIES.getProperty("maxProductId"));

        counter = new AtomicLong(1);
    }

    private static long MAX_ID_BOUNDER;
    private static AtomicLong counter;

    private ProductIdGenerator() { }

    public static long generateId(){
        LOCK.lock();

        if(counter.get() < MAX_ID_BOUNDER){
            LOCK.unlock();
            return counter.incrementAndGet();
        }
        else {
            LOGGER.fatal("ID for Product is not generated");
            throw new RuntimeException("Id value is bigger than, allowed: " + counter);
        }

    }

}
