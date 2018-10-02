package com.kozitski.triangle.validator;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.exception.InvalidAngleException;
import com.kozitski.triangle.exception.InvalidCoordinateException;
import com.kozitski.triangle.exception.InvalidSideException;
import com.kozitski.triangle.util.TriangleUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

public class TriangleValidator {
    private Properties properties;

    private static final Logger logger = Logger.getLogger(PointForTriangleValidator.class);

    public TriangleValidator() {
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/validationConfigurations.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {

            logger.error("TriangleValidator is not created");

        }

        logger.debug("TriangleValidator successfully created");
    }

    public void validate(PointForTriangle point1, PointForTriangle point2, PointForTriangle point3) throws InvalidCoordinateException{
        if(!TriangleUtils.isCanBeTriangle(point1, point2, point3)){
            throw new InvalidCoordinateException("These points are invalid for triangle: " + point1 + " " + point2 + " " + point3);
        }

        List<Double> sides = TriangleUtils.getSides(point1, point2, point3);
        List<Double> angles = TriangleUtils.getAngles(sides.get(0), sides.get(1), sides.get(2));

        validateSides(sides.get(0), sides.get(1), sides.get(2));
        validateAngles(angles.get(0), angles.get(1), angles.get(2));

        logger.debug("Triangle validation was successful");
    }

    private void validateSides(double side1, double side2, double side3) throws InvalidSideException {
        int minSide =  Integer.parseInt(properties.getProperty("sidesLoverBound"));
        int maxSide = Integer.parseInt(properties.getProperty("sidesHigherBound"));

        if((side1 < minSide || side2 < minSide || side3 < minSide) ||
                (side1 > maxSide || side2 > maxSide || side3 > maxSide) ||
                    checkSidesMathCondition(side1, side2, side3)){
            InvalidSideException exception = new InvalidSideException("Input sides are invalid: " + side1 + ", " + side2 + ", " + side3);
            logger.error("Validation sides was failed: " + exception);
            throw exception;
        }
    }
    private boolean checkSidesMathCondition(double side1, double side2, double side3){
        return !(((side1 + side2) > side3) || ((side1 + side3) > side2) || ((side3 + side2) > side1));
    }

    private void validateAngles(double angle1, double angle2, double angle3) throws InvalidAngleException {
        int minAngle =  Integer.parseInt(properties.getProperty("anglesLoverBound"));
        int maxAngle = Integer.parseInt(properties.getProperty("anglesHigherBound"));

        if((angle1 < minAngle || angle2 < minAngle || angle3 < minAngle) ||
                (angle1 > maxAngle || angle2 > maxAngle || angle3 > maxAngle) ||
                    !checkAnglesMathCondition(angle1, angle2, angle3)
                    ){
            InvalidAngleException exception = new InvalidAngleException("Input values are invalid: " + angle1 + ", " + angle2 + ", " + angle3);
            logger.error("Validation angles was failed: " + exception);
            throw exception;
        }
    }
    private boolean checkAnglesMathCondition(double angle1, double angle2, double angle3){
        if(Math.toDegrees((angle1 + angle2 + angle3)) > 180.1){
            return false;
        }
        return true;
    }

}
