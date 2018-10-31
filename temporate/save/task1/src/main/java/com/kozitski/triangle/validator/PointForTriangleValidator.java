package com.kozitski.triangle.validator;

import com.kozitski.triangle.exception.InvalidCoordinateException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointForTriangleValidator {
    private Properties properties;

    private static final Logger logger = LogManager.getLogger(PointForTriangleValidator.class);

    public PointForTriangleValidator() {
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/validationConfigurations.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {

            logger.error("PointForTriangleValidator is not created");

        }
        logger.info("PointForTriangleValidator successfully created");
    }

    public void validate(double x, double y) throws InvalidCoordinateException {
        int xMinValue = Integer.parseInt(properties.getProperty("pointXMinValue"));
        int xMaxValue = Integer.parseInt(properties.getProperty("pointXMaxValue"));
        int yMinValue = Integer.parseInt(properties.getProperty("pointYMinValue"));
        int yMaxValue = Integer.parseInt(properties.getProperty("pointYMaxValue"));

        logger.info("POINTS BOUNDS for PointForTriangleValidator from validationConfigurations.properties was got successfully");

        if((x < xMinValue || x > xMaxValue) || (y < yMinValue || y > yMaxValue)){
            InvalidCoordinateException exception = new InvalidCoordinateException("Input values are invalid: " + x + ", " + y);
            throw exception;
        }

    }

}
