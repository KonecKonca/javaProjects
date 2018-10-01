package com.kozitski.triangle.validator;

import com.kozitski.triangle.exception.InvalidCoordinateException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PointForTriangleValidator {
    private Properties properties;

    public PointForTriangleValidator() {
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/validationConfigurations.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {

            //  here must be logger

        }
    }

    public void validate(int x, int y) throws InvalidCoordinateException {
        int xMinValue =  Integer.parseInt(properties.getProperty("pointXMinValue"));
        int xMaxValue = Integer.parseInt(properties.getProperty("pointXMaxValue"));
        int yMinValue = Integer.parseInt(properties.getProperty("pointYMinValue"));
        int yMaxValue = Integer.parseInt(properties.getProperty("pointYMaxValue"));

        if((x < xMinValue || x > xMaxValue) || (y < yMinValue || y > yMaxValue)){
            throw new InvalidCoordinateException("Input values are invalid: " + x + ", " + y);
        }

    }

}
